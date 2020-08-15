package com.sanskar.springlearn.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    public Employee findByName(String firstName);
    public Employee findByEmpId(String empId);
    public Page<Employee> findAll(Pageable pageable);
}
