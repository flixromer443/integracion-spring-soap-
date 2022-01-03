package com.api1.api1.cars_controllers;

import java.util.List;

import com.api1.api1.orm.Car;

public interface ICarController {
    public List<Car> findCars();

}
