package by.itacademy.afisha.dao.entity;

import by.itacademy.afisha.controller.utils.json.LocalDateTimeDeserializer;
import by.itacademy.afisha.controller.utils.json.LocalDateTimeSerializer;
import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "events", schema ="afisha")
@SecondaryTable(name = "films",pkJoinColumns = @PrimaryKeyJoinColumn(name ="uuid_film"), schema = "afisha_test")
public class Film extends Event{
    private UUID country;
    private Integer releaseYear;
    private LocalDate releaseDate;
    private Integer duration;

    public Film() {
    }

    @Column(table = "films",name = "country")
    public UUID getCountry() {
        return country;
    }

    @Column(table = "films",name = "release_year")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    @Column(table = "films",name = "release_date")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Column(table = "films",name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setCountry(UUID country) {
        this.country = country;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
