package hu.unideb.inf.zootrekker.repository;

import hu.unideb.inf.zootrekker.entity.Substance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubstanceRepository extends JpaRepository<Substance, Integer> {}
