package com.mooveit.cars.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CATALOGUE")
public class Catalogue {
    private List<Model> models;

    public List<Model> getModels() {
        return models;
    }

    @XmlElement(name="MODEL")
    public void setModels(List<Model> models) {
        this.models = models;
    }
}
