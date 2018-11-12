package com.tn3.qualify.domain.car;

import com.tn3.qualify.domain.commons.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "BRANDS")
public class CarBrand extends AbstractEntity {

    @Column(name = "NAME")
    private String name;
}
