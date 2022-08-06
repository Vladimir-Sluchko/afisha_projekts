package by.itacademy.classifier_service.service.api;

import by.itacademy.classifier_service.service.dto.CountryCreateDto;
import by.itacademy.classifier_service.service.dto.CountryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

@Validated
public interface ICountryService {

    CountryCreateDto create(@Valid CountryCreateDto dto);


    PageDto<CountryReadDto> getAll(int page, int size);

    boolean сheckUuid(UUID uuid);

}
