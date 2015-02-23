package com.shop.test.repository;

import java.util.Iterator;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.Application;
import com.shop.domain.Person;
import com.shop.service.DomainObjectRepository;
import com.shop.service.PersonRepository;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class PersonRepositoryTest {
	
	@Resource
	private DomainObjectRepository domainObjectRepository;

	@Resource
	private PersonRepository personRepository;
	

	@Resource
	private EntityManagerFactory entityManagerFactory;
	
	@Test
	public void testSavePerson(){
		Person person = new Person();
		person.setFirstName("khim");
		person.setLastName("ung");
		person.setActive(true);
		
		Person expected = personRepository.save(person);
		//entityManagerFactory.createEntityManager().flush();
		Assert.assertNotNull(expected);
		
		System.out.println(expected.getFirstName());
		
		System.out.println(person.getId());
		System.out.println(expected.getId());
		
		Iterable<Person> itr = personRepository.findAll();
		
		Iterator<Person> iterator = itr.iterator();
		
		while(iterator.hasNext()){
			Person p = iterator.next();
			System.out.println(p.getFirstName());
		}
		
		Person found = personRepository.findOne(expected.getId());
		Assert.assertNotNull(found);
		Assert.assertNotNull(found);
	}
}
