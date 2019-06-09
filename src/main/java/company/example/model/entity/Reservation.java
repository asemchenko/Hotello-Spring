package company.example.model.entity;

import javax.persistence.*;

@Entity
public class Reservation {
    public Reservation(ApartmentOrder order) {
        this.apartmentOrder = order;
    }

    public Reservation() {
    }

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "order_id")
    private ApartmentOrder apartmentOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApartmentOrder getOrder() {
        return apartmentOrder;
    }

    public void setOrder(ApartmentOrder order) {
        this.apartmentOrder = order;
    }
}
