package by.itacademy.classifier_service.service.api;

import by.itacademy.classifier_service.service.dto.CategoryCreateDto;
import by.itacademy.classifier_service.service.dto.CategoryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

@Validated
public interface ICategoryService {
    CategoryCreateDto create(@Valid CategoryCreateDto dto);


    PageDto<CategoryReadDto> getAll(int page, int size);
    boolean сheckUuid(UUID uuid);
}
