package com.mooveit.cars.service.impl;

import com.mooveit.cars.domain.Model;
import com.mooveit.cars.exception.CarNotFoundException;
import com.mooveit.cars.repositories.ModelRepository;
import com.mooveit.cars.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository repository;

    @Override
    public List<Model> getAll() {
        return repository.findAll();
    }

    @Override
    public Model getById(Long id) throws CarNotFoundException {
        Optional<Model> optionalModel = repository.findById(id);
        return optionalModel.orElseThrow(()->new CarNotFoundException("Car not available"));
    }

    @Override
    public List<Model> getByName(String name) throws CarNotFoundException {
        List<Model> cars = repository.findByName(name);
        if(cars.isEmpty()){
            throw new CarNotFoundException("No cars available for the brand "+name);
        }
        return cars;
    }
}
