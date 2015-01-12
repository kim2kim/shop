package com.shop.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shop.domain.Person;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Long>{

}
