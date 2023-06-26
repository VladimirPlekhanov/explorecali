package com.example.ec.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * A classification of tours.
 */
public class TourPackage {

    @Id
    private String code;

    @Column
    private String name;

    protected TourPackage() {
    }

    public TourPackage(String code, String name) {
        this.code = code;
        this.name  = name;
    }

}
