package by.itacademy.afisha.service.dto;

import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;

import java.time.LocalDateTime;
import java.util.UUID;

public class FilmReadDto {

    private String uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String title;
    private String description;
    private Long dtEvent;
    private Long dtEndOfSale;
    private Type type;
    private Status status;

    public FilmReadDto() {
    }

    public FilmReadDto(String uuid, LocalDateTime dtCreate,
                       LocalDateTime dtUpdate, String title,
                       String description, Long dtEvent,
                       Long dtEndOfSale, Type type, Status status
                       ) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
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

}
