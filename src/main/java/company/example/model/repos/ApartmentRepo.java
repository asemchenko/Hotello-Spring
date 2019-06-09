package company.example.model.repos;

import company.example.model.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepo extends JpaRepository<Apartment, Long> {
}
