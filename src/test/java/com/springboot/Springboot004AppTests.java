package com.springboot;

import com.springboot.entity.PersonEntity;
import com.springboot.dao.PersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Springboot004App.class)
public class Springboot004AppTests {

	@Autowired
	private PersonDao personDao;

	@Test
	public void contextLoads() {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setAddress("WOW");
		personEntity.setName("WOW NAME");

		this.personDao.save(personEntity);
	}

}
