package hu.unideb.inf.zootrekker.repository;

import hu.unideb.inf.zootrekker.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
