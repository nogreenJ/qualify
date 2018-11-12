package com.tn3.qualify.domain.person;

import com.tn3.qualify.domain.commons.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PERSONS")
public class Person extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "CPF")
    private String cpf;
}
