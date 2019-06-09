package company.example.model.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class ApartmentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    /**
     * Always in time zone of region where hotel(apartment) placed
     */
    private LocalDate checkInDate;
    /**
     * Always in time zone of region where hotel(apartment) placed
     */
    private LocalDate checkOutDate;
    private long pricePerDayAtTheTimeOfOrder;
    private long totalPrice;
    private Instant creationTime;
    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = LocalDate.parse(checkInDate);
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = LocalDate.parse(checkOutDate);
    }

    public long getPricePerDayAtTheTimeOfOrder() {
        return pricePerDayAtTheTimeOfOrder;
    }

    public void setPricePerDayAtTheTimeOfOrder(long pricePerDayAtTheTimeOfOrder) {
        this.pricePerDayAtTheTimeOfOrder = pricePerDayAtTheTimeOfOrder;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}