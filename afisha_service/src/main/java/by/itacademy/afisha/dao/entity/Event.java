package by.itacademy.afisha.dao.entity;

import by.itacademy.afisha.controller.utils.json.LocalDateTimeDeserializer;
import by.itacademy.afisha.controller.utils.json.LocalDateTimeSerializer;
import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class Event {
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

    public Event() {
    }


    @Id
    @Column(name = "uuid")
    public UUID getUuid() {
        return uuid;
    }
    @Column(name = "dt_create")
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @Column(name = "dt_update")
    @Version
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "dt_event")
    public Long getDtEvent() {
        return dtEvent;
    }

    @Column(name = "dt_end_of_sale")
    public Long getDtEndOfSale() {
        return dtEndOfSale;
    }

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
    }

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

}

