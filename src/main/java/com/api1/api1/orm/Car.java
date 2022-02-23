package com.api1.api1.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "owner_id",nullable = false)
    private int owner_id;

    @Column(name = "mark",nullable = false)
    private String mark;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "domain",nullable = false)
    public String domain;


    public Car(){
    }
    public Car(int owner_id, String mark, String model, String domain) {
        this.owner_id = owner_id;
        this.mark = mark;
        this.model = model;
        this.domain = domain;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    
}
