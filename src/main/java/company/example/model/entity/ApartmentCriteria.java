package company.example.model.entity;

import java.time.LocalDate;

public class ApartmentCriteria {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private short apartmentClass;
    private short placesAmount;

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = LocalDate.parse(checkIn);
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = LocalDate.parse(checkOut);
    }

    public short getApartmentClass() {
        return apartmentClass;
    }

    public void setApartmentClass(short apartmentClass) {
        this.apartmentClass = apartmentClass;
    }

    public short getPlacesAmount() {
        return placesAmount;
    }

    public void setPlacesAmount(short placesAmount) {
        this.placesAmount = placesAmount;
    }
}
