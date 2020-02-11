package com.qa.persistence.dao;

import java.util.List;

import com.qa.persistence.domain.Customer;

public interface Dao<T> {

    List<T> readAll();
     
    T create(T t);
     
    T update(T t);
     
    void delete(String id);


}
	