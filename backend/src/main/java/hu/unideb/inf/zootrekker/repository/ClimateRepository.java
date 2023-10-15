package hu.unideb.inf.zootrekker.repository;

import hu.unideb.inf.zootrekker.entity.Climate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateRepository extends JpaRepository<Climate, Long> {}