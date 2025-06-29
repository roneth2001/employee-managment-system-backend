package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp) {
        return repository.save(emp);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
        emp.setId(id);
        return repository.save(emp);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}