package hu.unideb.inf.zootrekker.repository;

import hu.unideb.inf.zootrekker.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
