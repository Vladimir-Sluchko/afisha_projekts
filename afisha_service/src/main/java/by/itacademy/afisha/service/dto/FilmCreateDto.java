package by.itacademy.afisha.service.dto;

import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class FilmCreateDto {
    @NotBlank(message = "Enter title")
    private String title;
    @NotBlank(message = "Enter description")
    private String description;
    private Long dtEvent;
    private Long dtEndOfSale;
    @NotBlank(message = "Enter type")
    private Type type;
    @NotBlank(message = "Enter status")
    private Status status;
    private UUID country;
    @NotBlank(message = "Enter releaseYear")
    private Integer releaseYear;
    @NotBlank(message = "Enter releaseDate")
    private LocalDate releaseDate;
    @NotBlank(message = "Enter releaseDate")
    @PositiveOrZero
    private Integer duration;

    public FilmCreateDto() {
    }

    public FilmCreateDto(String title,
                         String description, Long dtEvent,
                         Long dtEndOfSale, Type type, Status status,
                         UUID country, Integer releaseYear, LocalDate releaseDate,
                         Integer duration) {

        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.country = country;
        this.releaseYear = releaseYear;
        this.releaseDate = releaseDate;
        this.duration = duration;
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

    public Long getDtEvent() {
        return dtEvent;
    }

    public void setDtEvent(Long dtEvent) {
        this.dtEvent = dtEvent;
    }

    public Long getDtEndOfSale() {
        return dtEndOfSale;
    }

    public void setDtEndOfSale(Long dtEndOfSale) {
        this.dtEndOfSale = dtEndOfSale;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getCountry() {
        return country;
    }

    public void setCountry(UUID country) {
        this.country = country;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}
