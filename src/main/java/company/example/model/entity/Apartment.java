package company.example.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private short placesAmount;
    private short roomsAmount;
    private String description;
    private long pricePerDay;
    private short starsAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getPlacesAmount() {
        return placesAmount;
    }

    public void setPlacesAmount(short placesAmount) {
        this.placesAmount = placesAmount;
    }

    public short getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(short roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public long getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(long pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public short getStarsAmount() {
        return starsAmount;
    }

    public void setStarsAmount(short starsAmount) {
        this.starsAmount = starsAmount;
    }
}