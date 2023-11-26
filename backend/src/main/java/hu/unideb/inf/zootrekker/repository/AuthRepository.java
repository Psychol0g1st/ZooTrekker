package hu.unideb.inf.zootrekker.repository;

import hu.unideb.inf.zootrekker.entity.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {}
