package com.tn3.qualify.service;

import com.tn3.qualify.domain.car.Car;
import com.tn3.qualify.persistence.BrandRepository;
import com.tn3.qualify.persistence.CarRepository;
import com.tn3.qualify.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.tn3.qualify.domain.car.CarType.getCarTypeSelectionMap;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final PersonRepository personRepository;

    @Autowired
    public CarService(
        CarRepository carRepository,
        BrandRepository brandRepository,
        PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.personRepository = personRepository;
    }

    public Map<String, Object> getModuleInitInfo() {
        Map<String, Object> values = new HashMap<>();
        values.put("brands", brandRepository.findAll());
        values.put("owners", personRepository.findAll());
        values.put("types", getCarTypeSelectionMap());
        return values;
    }

    public Iterable<Car> getCarList() {
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }
}
