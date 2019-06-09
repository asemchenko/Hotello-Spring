package company.example.model.repos;

import company.example.model.entity.ApartmentOrder;
import company.example.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    Reservation findByApartmentOrder(ApartmentOrder order);
}
