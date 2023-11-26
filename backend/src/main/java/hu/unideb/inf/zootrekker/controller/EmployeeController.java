package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Employee;
import hu.unideb.inf.zootrekker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return  employeeService.saveEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getall")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
        return  employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return "Deleted successfully";
    }

}
