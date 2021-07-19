package com.mooveit.cars.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "engine")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int power;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    @XmlAttribute(name = "power")
    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute(name = "type")
    public void setType(String type) {
        this.type = type;
    }
}
