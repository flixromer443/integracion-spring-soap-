package com.api1.api1.cars_controllers;

import java.util.List;

import com.api1.api1.orm.Car;
import com.api1.api1.repositories.ICarJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api1/v1")
public class CarController implements ICarController {
    @Autowired
    private ICarJpaRepository ICarJpa;

    @Override
    @GetMapping("/cars")
    public List<Car> findCars(){
        return ICarJpa.findAll();
    }
    @PostMapping("/cars")
    public Car create(@RequestBody Car car) {
        return ICarJpa.save(car);
    }
    /*@PutMapping("/cars/{id}")
    public Car putMethodName(@RequestBody Car car,@PathVariable Integer id) {
        Car carbase=ICarJpa.getOne(id);
        carbase.setMark(car.getMark());
        carbase.setModel(car.getModel());
        carbase.setOwner_id(car.getOwner_id());
        carbase.setDomain(car.getDomain());
        return ICarJpa.save(carbase);
    
    }*/
    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable Integer id){
        ICarJpa.deleteById(id);
    }
    
}
