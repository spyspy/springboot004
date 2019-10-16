package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * JpaRepository<T,ID>
 *     T: 目前的Mapping 實體，也就是 Person
 *     ID: 目前的實體ID
 *
 */

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    Person findPersonById(int id);
}
