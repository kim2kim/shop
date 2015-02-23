package com.shop.test.repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.shop.Application;
import com.shop.model.User;
import com.shop.service.UserRepository;
import com.shop.test.context.TestContext;

//@Configuration
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
//@ContextConfiguration(classes = {TestContext.class, Application.class})
@SpringApplicationConfiguration(classes = {Application.class, TestContext.class})
//@Transactional
@DatabaseSetup("sample-data.xml")
public class UserRepositoryTest {

	@Resource
	UserRepository userRepository;

	//@Resource
	//private DataSource dataSource;

	private User testUser;

	private PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Before
	public void init() {
		testUser = userRepository.findOne(new Long("1"));
		Assert.assertNotNull(testUser);
	}
	
	/*
	@Bean(name = "dbUnitDatabaseConnection")
	public DatabaseDataSourceConnectionFactoryBean dbunitDatabaseConnection(DataSource datasource){
		DatabaseDataSourceConnectionFactoryBean dbUnitDBConnection = new DatabaseDataSourceConnectionFactoryBean();
		dbUnitDBConnection.setDataSource(datasource);
		dbUnitDBConnection.setSchema("testshop");
		return dbUnitDBConnection;
	}
*/

	@Test
	
	public void testSaveUser() {
		User found = userRepository.findByUsernameAndPassword(testUser.getUsername(), testUser.getPassword());

		Assert.assertNotNull(found);
		Assert.assertEquals("khim_ung@gmail.com", found.getUsername());
		Assert.assertEquals(encoder.encode("password"), found.getPassword());
	}
}
