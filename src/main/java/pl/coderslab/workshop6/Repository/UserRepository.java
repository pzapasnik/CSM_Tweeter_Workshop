package pl.coderslab.workshop6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.workshop6.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String Email);
}

