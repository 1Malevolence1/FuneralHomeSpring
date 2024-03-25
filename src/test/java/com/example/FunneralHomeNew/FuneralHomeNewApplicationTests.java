package com.example.FunneralHomeNew;

import com.example.FunneralHomeNew.models.passport.Passport;
import com.example.FunneralHomeNew.models.person.Person;
import com.example.FunneralHomeNew.models.person.employess.Employee;
import com.example.FunneralHomeNew.repository.EmployeeRepository;
import com.example.FunneralHomeNew.repository.PassportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FuneralHomeNewApplicationTests {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private PassportRepository passportRepository;
	@Test
	public void testDeletePassport(){

	/*
		Passport passport = passportRepository.findByNumber("123456");
		passportRepository.delete(passport);*/



	}

	@Test
	void contextLoads() {

	}

}
