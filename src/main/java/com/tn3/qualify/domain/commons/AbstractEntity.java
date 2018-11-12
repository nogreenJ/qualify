package com.tn3.qualify.domain.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

@Data
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    protected Long id;
}
