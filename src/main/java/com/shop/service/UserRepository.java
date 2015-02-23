package com.shop.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shop.model.User;

@RepositoryRestResource
@RepositoryDefinition(domainClass=User.class, idClass=Long.class)
public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUsernameAndPassword(String username, String encryptedPassword);
}
