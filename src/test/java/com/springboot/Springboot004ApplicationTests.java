package com.springboot;

import com.springboot.dao.Person;
import com.springboot.dao.PersonRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Springboot004Application.class)
public class Springboot004ApplicationTests {

	@Autowired
	private PersonRepo personRepo;

	@Test
	public void contextLoads() {
		Person person = new Person();
		person.setAddress("WOW");
		person.setName("WOW NAME");

		this.personRepo.save(person);
	}

}
