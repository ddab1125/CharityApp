package pl.coderslab.charity.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
