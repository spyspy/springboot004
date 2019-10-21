package com.springboot.dao;

import com.springboot.entity.PersonEntity;

/**
 *
 * https://www.baeldung.com/spring-data-jpa-method-in-all-repositories
 *
 *
 */

public interface ExtendRepository extends BaseDao<PersonEntity, Long> {
}