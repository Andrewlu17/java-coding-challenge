package com.mooveit.cars.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Entity
@Table(name = "models")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Integer fromYear;
    private Integer to;
    private String type;

    @OneToOne(targetEntity = Engine.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Engine engine;

    @OneToOne(targetEntity = Wheel.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Wheel wheel;

    @OneToMany(targetEntity = SubModel.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<SubModel> subModels;

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

    public String getType() {
        return type;
    }

    @XmlAttribute(name = "type")
    public void setType(String type) {
        this.type = type;
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

    public List<SubModel> getSubModels() {
        return subModels;
    }

    @XmlElementWrapper(name="SUBMODELS")
    @XmlElement(name = "MODEL")
    public void setSubModels(List<SubModel> subModels) {
        this.subModels = subModels;
    }

}
