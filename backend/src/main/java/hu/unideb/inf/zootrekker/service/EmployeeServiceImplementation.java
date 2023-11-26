package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Employee;
import hu.unideb.inf.zootrekker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        if (employeeRepository.findById(id).isPresent())
            return employeeRepository.findById(id).get();
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Optional<Employee> employeeToUpdate = employeeRepository.findById(id);
        if (employeeToUpdate.isPresent())
            employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
