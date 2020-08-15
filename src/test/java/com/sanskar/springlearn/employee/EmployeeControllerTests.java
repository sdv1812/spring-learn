package com.sanskar.springlearn.employee;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EmployeeControllerTests {


    @Test
    public void testEmployeeName1() {
        EmployeeController employeeController = new EmployeeController();
        String result = employeeController.emplyeeName();
        assertEquals(result, "emp1");
    }

    @Test
    public void testEmployeeName2() {
        EmployeeController employeeController = new EmployeeController();
        String result = employeeController.emplyeeName();
        assertNotEquals(result, "emp3");
    }

    @Test
    public void testEmployeeDetails() {
        Employee employee = new Employee("emp001", "Sanskar", "software engineer", 5000.00);

        EmployeeController employeeController = new EmployeeController();
        Employee emp = employeeController.employeeDetails("emp001");
        assertEquals("emp001", emp.getEmpId());
    }

}
