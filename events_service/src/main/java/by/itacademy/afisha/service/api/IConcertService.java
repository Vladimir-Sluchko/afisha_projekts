package by.itacademy.afisha.service.api;

import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.service.dto.ConcertCreateDto;
import by.itacademy.afisha.service.dto.ConcertReadDto;
import by.itacademy.afisha.service.dto.PageDto;

import java.util.UUID;

public interface IConcertService extends IService<ConcertCreateDto, ConcertReadDto> {
    //@Override
    ConcertCreateDto create(ConcertCreateDto eventFilm);

    //@Override
    ConcertReadDto get(UUID uuid);

    //@Override
    PageDto<ConcertReadDto> getAll(int page, int size);

    //@Override
    ConcertCreateDto update(ConcertCreateDto eventFilm, UUID uuid, Long dtUpdate);
}
