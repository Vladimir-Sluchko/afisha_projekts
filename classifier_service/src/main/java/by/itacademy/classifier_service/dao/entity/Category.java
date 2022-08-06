package by.itacademy.classifier_service.dao.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "category", schema = "library")
public class Category {
    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String title;

    public Category() {
    }

    @Id
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

    public String getTitle() {
        return title;
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


}
