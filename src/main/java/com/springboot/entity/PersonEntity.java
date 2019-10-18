package com.springboot.entity;

import javax.persistence.*;

//@Table(name = "persons")   ie: "persons" is the table name

@Entity
@Table(name = "persons")
public class PersonEntity {

    /**
     *     @GeneratedValue(strategy = GenerationType.AUTO)
     *     This cannot be used in "Primary Key"!!! Only GenerationType.IDENTITY !!
     */


    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
