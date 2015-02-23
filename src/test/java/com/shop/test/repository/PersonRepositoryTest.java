package com.shop.test.repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.Application;
import com.shop.domain.Person;
import com.shop.service.PersonRepository;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class PersonRepositoryTest {

	@Resource
	private PersonRepository personRepository;
	

	@Test
	public void testSavePerson(){
		Person person = new Person();
		person.setFirstName("khim");
		person.setLastName("ung");
		person.setActive(true);
		
		Person expected = personRepository.save(person);
		Assert.assertNotNull(expected);
		
		System.out.println(person.getId());
		System.out.println(expected.getId());
		
		Person found = personRepository.findOne(expected.getId());
		Assert.assertNotNull(found);
		Assert.assertNotNull(found);
	}
}
