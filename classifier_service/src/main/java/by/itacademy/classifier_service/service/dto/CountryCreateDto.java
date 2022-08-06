package by.itacademy.classifier_service.service.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class CountryCreateDto {
    @NotBlank(message = "Enter title")
    private String title;
    @NotBlank(message = "Enter description")
    private String description;

    public CountryCreateDto() {
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
