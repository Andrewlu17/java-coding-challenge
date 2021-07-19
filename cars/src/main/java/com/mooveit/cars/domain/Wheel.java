package com.mooveit.cars.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;

@Entity
@Table(name = "wheels")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String size;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    @XmlAttribute(name = "size")
    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute(name = "type")
    public void setType(String type) {
        this.type = type;
    }
}
