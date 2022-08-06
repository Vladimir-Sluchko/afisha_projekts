package by.itacademy.afisha.service.dto;

import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class ConcertCreateDto {
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
    private UUID category;


    public ConcertCreateDto() {
    }

    public ConcertCreateDto(String title, String description,
                            Long dtEvent, Long dtEndOfSale,
                            Type type, Status status, UUID category) {
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.category = category;
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

    public UUID getCategory() {
        return category;
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

    public void setCategory(UUID category) {
        this.category = category;
    }


    public static final class Builder {

        private String title;
        private String description;
        private Long dtEvent;
        private Long dtEndOfSale;
        private Type type;
        private Status status;
        private UUID category;


        public Builder() {
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

        public Builder setCategory(UUID category) {
            this.category = category;
            return this;
        }


        public static Builder create(){
            return new Builder();
        }

        public ConcertCreateDto build(){
            return new ConcertCreateDto(title, description, dtEvent,
                                      dtEndOfSale, type, status, category);
        }
    }
}
