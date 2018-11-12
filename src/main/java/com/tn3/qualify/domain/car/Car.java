package com.tn3.qualify.domain.car;

import com.tn3.qualify.domain.commons.AbstractEntity;
import com.tn3.qualify.domain.person.Person;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "CARS")
public class Car extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private CarBrand brand;

    @Enumerated(STRING)
    @Column(name = "TYPE")
    private CarType type;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "OWNER_ID")
    private Person owner;
}
