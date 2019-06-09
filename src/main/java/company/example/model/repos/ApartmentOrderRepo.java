package company.example.model.repos;

import company.example.model.entity.ApartmentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ApartmentOrderRepo extends JpaRepository<ApartmentOrder, Long> {
    Collection<ApartmentOrder> findAllByUserId(long userId);
}