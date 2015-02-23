package com.shop.service;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.shop.domain.DomainObject;

@NoRepositoryBean
public interface DomainObjectRepository<T extends DomainObject, E extends Serializable> extends
        CrudRepository<T, E> {

}