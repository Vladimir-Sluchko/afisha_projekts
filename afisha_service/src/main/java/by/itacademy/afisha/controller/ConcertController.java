package by.itacademy.afisha.controller;

import by.itacademy.afisha.service.api.IConcertService;
import by.itacademy.afisha.service.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/afisha/event/concerts")
public class ConcertController {
    private final IConcertService service;

    public ConcertController(IConcertService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ConcertCreateDto> create(@RequestBody ConcertCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<PageDto> getAll(@RequestParam(name = "size", defaultValue = "5") int size,
                                          @RequestParam(name = "page", defaultValue = "1") int page){
        return ResponseEntity.ok(service.getAll(page,size));

    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ConcertReadDto> get(@PathVariable UUID uuid){
        return ResponseEntity.ok(service.get(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<ConcertCreateDto> update (@RequestBody ConcertCreateDto dto,
                                                 @PathVariable UUID uuid,
                                                 @PathVariable(name = "dt_update") Long dtUpdate){
        return ResponseEntity.ok(service.update(dto,uuid,dtUpdate));
    }
}
