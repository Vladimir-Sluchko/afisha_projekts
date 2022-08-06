package by.itacademy.afisha.service.dto;

import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;

import java.time.LocalDateTime;
import java.util.UUID;

public class ConcertReadDto {
    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String title;
    private String description;
    private Long dtEvent;
    private Long dtEndOfSale;
    private Type type;
    private Status status;
    private String author;



    public ConcertReadDto() {
    }

    public ConcertReadDto(UUID uuid, LocalDateTime dtCreate,
                          LocalDateTime dtUpdate, String title,
                          String description, Long dtEvent, Long dtEndOfSale,
                          Type type, Status status,String author) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.author = author;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getDtEvent() {
        return dtEvent;
    }

    public Long getDtEndOfSale() {
        return dtEndOfSale;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDtEvent(Long dtEvent) {
        this.dtEvent = dtEvent;
    }

    public void setDtEndOfSale(Long dtEndOfSale) {
        this.dtEndOfSale = dtEndOfSale;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static final class Builder {

        private UUID uuid;
        private LocalDateTime dtCreate;
        private LocalDateTime dtUpdate;
        private String title;
        private String description;
        private Long dtEvent;
        private Long dtEndOfSale;
        private Type type;
        private Status status;
        private String author;

        public Builder() {
        }

        public Builder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder setDtCreate(LocalDateTime dtCreate) {
            this.dtCreate = dtCreate;
            return this;
        }

        public Builder setDtUpdate(LocalDateTime dtUpdate) {
            this.dtUpdate = dtUpdate;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDtEvent(Long dtEvent) {
            this.dtEvent = dtEvent;
            return this;
        }

        public Builder setDtEndOfSale(Long dtEndOfSale) {
            this.dtEndOfSale = dtEndOfSale;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }
        public Builder setAuthor(String author){
            this.author = author;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public ConcertReadDto build(){
            return new ConcertReadDto(uuid, dtCreate, dtUpdate,
                    title, description, dtEvent,
                    dtEndOfSale, type, status, author);
        }
    }
}
