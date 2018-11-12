package com.tn3.qualify.api;

import com.tn3.qualify.domain.car.Car;
import com.tn3.qualify.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarRestApi {

    private final CarService carService;

    @Autowired
    public CarRestApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("car/initinfo")
    public ResponseEntity getInitInfo() {
        return ResponseEntity.ok(carService.getModuleInitInfo());
    }

    @GetMapping("car/lst")
    public ResponseEntity getCarList() {
        return ResponseEntity.ok(carService.getCarList());
    }

    @PostMapping("car/save")
    public ResponseEntity createCar(@ModelAttribute Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @GetMapping("car/helloajax")
    public ResponseEntity helloAjax() {
        return ResponseEntity.ok("Hello Ajax!");
    }
}
