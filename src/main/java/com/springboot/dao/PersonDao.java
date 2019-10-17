package com.springboot.dao;

import com.springboot.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * JpaRepository<T,ID>
 *     T: 目前的Mapping 實體，也就是 PersonEntity
 *     ID: 目前的實體ID
 *
 */

@Repository
public interface PersonDao extends JpaRepository<PersonEntity, Integer> {
    PersonEntity findPersonById(int id);
}
