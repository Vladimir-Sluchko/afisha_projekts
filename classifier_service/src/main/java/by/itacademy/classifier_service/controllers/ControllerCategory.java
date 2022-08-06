package by.itacademy.classifier_service.controllers;

import by.itacademy.classifier_service.service.api.ICategoryService;
import by.itacademy.classifier_service.service.dto.CategoryCreateDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/classifier")
public class ControllerCategory {
    private final ICategoryService service;

    public ControllerCategory(ICategoryService service) {
        this.service = service;
    }
    @PostMapping("/concert/category")
    public ResponseEntity<CategoryCreateDto> create (@Valid @RequestBody CategoryCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping("/concert/category")
    public ResponseEntity<PageDto> get (@RequestParam(name = "page",defaultValue = "1") int page,
                                        @RequestParam(name = "size", defaultValue = "20") int size){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/concert/check/{uuid}")
    public ResponseEntity<UUID> сheckUuid (@PathVariable UUID uuid){
        if (this.service.сheckUuid(uuid)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
