package com.tn3.qualify.persistence;

import com.tn3.qualify.domain.car.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

}
