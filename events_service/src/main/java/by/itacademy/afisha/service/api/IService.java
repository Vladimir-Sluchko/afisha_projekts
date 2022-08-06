package by.itacademy.afisha.service.api;

import by.itacademy.afisha.service.dto.FilmCreateDto;
import by.itacademy.afisha.service.dto.PageDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IService<C,R> {
    C create (C eventFilm);
    R get (UUID uuid);
    PageDto<R> getAll(int page, int size );
    C update (C eventFilm, UUID uuid, Long dtUpdate);
}
