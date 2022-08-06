package by.itacademy.afisha.controller;

import by.itacademy.afisha.service.dto.FilmCreateDto;
import by.itacademy.afisha.service.dto.FilmReadDto;
import by.itacademy.afisha.service.api.IFilmService;
import by.itacademy.afisha.service.dto.PageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/afisha/event/films")
public class FilmsController {
    private final IFilmService eventFilmService;

    public FilmsController(IFilmService eventFilmService) {
        this.eventFilmService = eventFilmService;
    }

    @PostMapping
    public ResponseEntity<FilmCreateDto> create(@RequestBody FilmCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventFilmService.create(dto));
    }

    @GetMapping
    public ResponseEntity<PageDto> getAll(@RequestParam(name = "size", defaultValue = "5") int size,
                                          @RequestParam(name = "page", defaultValue = "1") int page){
        return ResponseEntity.ok(eventFilmService.getAll(page,size));

    }

    @GetMapping("/{uuid}")
    public ResponseEntity<FilmReadDto> get(@PathVariable UUID uuid){
        return ResponseEntity.ok(eventFilmService.get(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<FilmCreateDto> update (@RequestBody FilmCreateDto dto,
                                                 @PathVariable UUID uuid,
                                                 @PathVariable(name = "dt_update") Long dtUpdate){
        return ResponseEntity.ok(eventFilmService.update(dto,uuid,dtUpdate));
    }


}
