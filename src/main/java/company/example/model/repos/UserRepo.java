package company.example.model.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import company.example.model.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
