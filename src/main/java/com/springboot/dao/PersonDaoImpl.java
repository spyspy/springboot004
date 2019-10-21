package com.springboot.dao;

import com.springboot.entity.PersonEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao{
    @Override
    public PersonEntity findPersonById(int id) {
        return null;
    }

    @Override
    public List<PersonEntity> findAll() {
        return null;
    }

    @Override
    public List<PersonEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PersonEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PersonEntity> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(PersonEntity personEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends PersonEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PersonEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends PersonEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<PersonEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PersonEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<PersonEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PersonEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends PersonEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PersonEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PersonEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PersonEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PersonEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PersonEntity> boolean exists(Example<S> example) {
        return false;
    }
}
