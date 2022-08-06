package by.itacademy.afisha.service.api;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.service.dto.FilmCreateDto;
import by.itacademy.afisha.service.dto.FilmReadDto;
import by.itacademy.afisha.service.dto.PageDto;
import org.springframework.data.domain.Page;

import java.util.UUID;


public interface IFilmService extends IService<FilmCreateDto, FilmReadDto> {
    //@Override
    FilmCreateDto create(FilmCreateDto eventFilm);

    //@Override
    FilmReadDto get(UUID uuid);

    //@Override
    PageDto<FilmReadDto> getAll(int page, int size);

    //@Override
    FilmCreateDto update (FilmCreateDto eventFilm, UUID uuid, Long dtUpdate);
}
