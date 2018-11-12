package com.tn3.qualify.persistence;

import com.tn3.qualify.domain.car.CarBrand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<CarBrand, Long> {

}
