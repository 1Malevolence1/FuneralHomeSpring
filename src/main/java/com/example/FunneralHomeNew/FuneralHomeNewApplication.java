package com.example.FunneralHomeNew;


import com.example.FunneralHomeNew.repository.EmployeeRepository;
import com.example.FunneralHomeNew.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class FuneralHomeNewApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private PassportRepository passportRepository;
	public static void main(String[] args) {
		SpringApplication.run(FuneralHomeNewApplication.class, args);
		}


	@Override
	public void run(String... args) throws Exception {

	}
}

