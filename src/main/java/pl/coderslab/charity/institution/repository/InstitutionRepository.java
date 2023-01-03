package pl.coderslab.charity.institution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.institution.entity.Institution;


@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {


}
