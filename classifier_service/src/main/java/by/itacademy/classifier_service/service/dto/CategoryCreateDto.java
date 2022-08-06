package by.itacademy.classifier_service.service.dto;

import javax.validation.constraints.NotBlank;

public class CategoryCreateDto {
    @NotBlank(message = "Enter title")
    private String title;

    public CategoryCreateDto() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
