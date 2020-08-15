package com.sanskar.springlearn.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String emplyeeName() {
        Employee emp = new Employee();
        emp.setName("emp1");
        return emp.getName();
    }
    
    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
    public Employee employeeDetails(@PathVariable(name = "empId") String empId) {
        return employeeRepository.findByEmpId(empId);
    }

}