package com.mooveit.cars.service;

import com.mooveit.cars.domain.Model;
import com.mooveit.cars.exception.CarNotFoundException;

import java.util.List;

public interface ModelService {

    List<Model> getAll();

    Model getById(Long id) throws CarNotFoundException;

    List<Model> getByName(String name) throws CarNotFoundException;
}
