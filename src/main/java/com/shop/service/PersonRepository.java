package com.shop.service;

import javax.transaction.Transactional;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shop.domain.Person;

@RepositoryRestResource
@RepositoryDefinition(domainClass=Person.class, idClass=Long.class)
@Transactional
public interface PersonRepository extends DomainObjectRepository<Person, Long>{

}
