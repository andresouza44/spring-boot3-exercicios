package com.net.javaguides.backendemployee;

import com.net.javaguides.backendemployee.model.Employee;
import com.net.javaguides.backendemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendEmployeeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendEmployeeApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("André");
//		employee.setLastName("Martins de Souza");
//		employee.setEmailId("andre@gmail.com");
//		employeeRepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Letícia");
//		employee1.setLastName("Letícia S. Lorenzetti");
//		employee1.setEmailId("leticia@gmail.com");
//		employeeRepository.save(employee1);
	}
}
