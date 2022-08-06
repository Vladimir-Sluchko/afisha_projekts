package by.itacademy.classifier_service.controllers;

import by.itacademy.classifier_service.service.api.ICountryService;
import by.itacademy.classifier_service.service.dto.CountryCreateDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/classifier")
public class ControllerCountry {

    private final ICountryService service;

    public ControllerCountry(ICountryService service) {
        this.service = service;
    }

    @PostMapping("/country")
    public ResponseEntity<CountryCreateDto> create (@Valid @RequestBody CountryCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }


    @GetMapping("/country")
    public ResponseEntity<PageDto> get (@RequestParam(name = "page", defaultValue = "1") int page,
                                        @RequestParam(name = "size",defaultValue = "20") int size){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/country/check/{uuid}")
    public ResponseEntity<UUID> сheckUuid (@PathVariable UUID uuid){
        if (this.service.сheckUuid(uuid)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
