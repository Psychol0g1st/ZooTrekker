package hu.unideb.inf.zootrekker.repository;

import hu.unideb.inf.zootrekker.entity.AnimalDiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnimalDietRepository extends JpaRepository<AnimalDiet, Long> {}
