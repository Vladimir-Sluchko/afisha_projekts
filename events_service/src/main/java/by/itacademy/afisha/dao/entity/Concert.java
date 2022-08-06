package by.itacademy.afisha.dao.entity;

import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "event",schema = "afisha_test")
@SecondaryTable(name = "concert",pkJoinColumns = @PrimaryKeyJoinColumn(name = "uuid_concert"),schema = "afisha_test")
public class Concert extends Event{
    private UUID category;

    public Concert() {
    }

    @Column(table = "concert",name = "category")
    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
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
        private UUID category;

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

        public Builder setCategory(UUID category) {
            this.category = category;
            return this;
        }

        public static Builder create() {
            return new Builder();
        }

        public Concert build() {
            Concert concert = new Concert();
            concert.setUuid(uuid);
            concert.setDtCreate(dtCreate);
            concert.setDtUpdate(dtUpdate);
            concert.setTitle(title);
            concert.setDescription(description);
            concert.setDtEvent(dtEvent);
            concert.setDtEndOfSale(dtEndOfSale);
            concert.setType(type);
            concert.setStatus(status);
            concert.setCategory(category);

            return concert;
        }
    }
}
