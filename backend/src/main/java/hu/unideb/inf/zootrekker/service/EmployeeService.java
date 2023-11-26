package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.classes.Login;
import hu.unideb.inf.zootrekker.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployee(Long id);

    Employee login(Login loginData);
}
