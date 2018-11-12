package com.tn3.qualify.domain.car;

import java.util.EnumSet;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public enum CarType {
    HATCH("Hatch"),
    SEDAN("Sedan"),
    SUV("Utilitário"),
    SPORT("Esportivo");

    CarType(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public static Map<String, String> getCarTypeSelectionMap() {
        return EnumSet.allOf(CarType.class)
                      .stream()
                      .collect(toMap(CarType::name, CarType::getDescription));
    }
}
