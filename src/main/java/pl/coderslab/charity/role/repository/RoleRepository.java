package pl.coderslab.charity.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.role.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
