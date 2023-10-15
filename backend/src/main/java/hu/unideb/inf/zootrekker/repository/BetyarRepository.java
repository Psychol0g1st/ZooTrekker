package hu.unideb.inf.zootrekker.repository;

import hu.unideb.inf.zootrekker.entity.Betyar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetyarRepository extends JpaRepository<Betyar, Long> {}
