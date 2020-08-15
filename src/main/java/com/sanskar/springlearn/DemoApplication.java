package com.sanskar.springlearn;

import com.sanskar.springlearn.employee.Employee;
import com.sanskar.springlearn.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		// save a couple of customers
		repository.save(new Employee("emp001", "Sanskar", "software engineer", 5000.00));
		repository.save(new Employee("emp002", "Ada", "MD", 6000.00));
		repository.save(new Employee("emp003", "Ann", "Product Specialist", 3700.00));
		repository.save(new Employee("emp004", "Ann", "Product Specialist", 3700.00));
		repository.save(new Employee("emp005", "Ann", "Product Specialist", 3700.00));
		// fetch all customers
		System.out.println("Employees found with findAll():");
		System.out.println("-------------------------------");
		for (Employee employee : repository.findAll()) {
			System.out.println(employee);
		}
		System.out.println();
		// fetch an individual customer
		System.out.println("Employee found with employee id('emp001'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByEmpId("emp001"));

		System.out.println("Employee found with findAll(pagination):");
		System.out.println("--------------------------------");
		Pageable sortedByName =
				PageRequest.of(0, 2, Sort.by("empId").descending());
		for (Employee employee : repository.findAll(sortedByName)) {
			System.out.println(employee);
		}
	}
}
