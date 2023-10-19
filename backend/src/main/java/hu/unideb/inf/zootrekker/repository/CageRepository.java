package hu.unideb.inf.zootrekker.repository;

import hu.unideb.inf.zootrekker.entity.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageRepository extends JpaRepository<Cage, Long> {}
