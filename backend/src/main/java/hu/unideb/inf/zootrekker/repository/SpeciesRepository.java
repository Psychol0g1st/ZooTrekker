package hu.unideb.inf.zootrekker.repository;

import hu.unideb.inf.zootrekker.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {}
