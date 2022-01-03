package com.api1.api1.repositories;

import com.api1.api1.orm.Car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarJpaRepository extends JpaRepository<Car,Integer> {
    
}
