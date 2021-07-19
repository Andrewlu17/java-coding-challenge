package com.mooveit.cars.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "sub_model")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Integer fromYear;
    private Integer to;
    private String line;

    @OneToOne(targetEntity = Engine.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Engine engine;

    @OneToOne(targetEntity = Wheel.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Wheel wheel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getFromYear() {
        return fromYear;
    }

    @XmlAttribute(name = "from")
    public void setFromYear(Integer fromYear) {
        this.fromYear = fromYear;
    }

    public Integer getTo() {
        return to;
    }

    @XmlAttribute(name = "to")
    public void setTo(Integer to) {
        this.to = to;
    }

    public String getLine() {
        return line;
    }

    @XmlAttribute(name = "line")
    public void setLine(String line) {
        this.line = line;
    }

    public Engine getEngine() {
        return engine;
    }

    @XmlElement(name = "ENGINE")
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel getWheel() {
        return wheel;
    }

    @XmlElement(name = "WHEELS")
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}
