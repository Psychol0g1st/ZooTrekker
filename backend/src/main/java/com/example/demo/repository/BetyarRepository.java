package com.example.demo.repository;

import com.example.demo.entity.Betyar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.hibernate.dialect.MariaDBDialect;
@Repository
public interface BetyarRepository extends JpaRepository<Betyar, Long> {}
