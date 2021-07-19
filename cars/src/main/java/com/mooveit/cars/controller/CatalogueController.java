package com.mooveit.cars.controller;

import com.mooveit.cars.domain.Model;
import com.mooveit.cars.exception.CarNotFoundException;
import com.mooveit.cars.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/models")
public class CatalogueController {

    @Autowired
    private ModelService modelService;

    @GetMapping
    public ResponseEntity<List<Model>> getAll(){
        return new ResponseEntity<>(modelService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<?> getByIdAndBrandName(@PathVariable("identifier") String identifier) throws CarNotFoundException {
        try{
            return new ResponseEntity<>(modelService.getById(Long.parseLong(identifier)),HttpStatus.OK);
        }catch (NumberFormatException e){
            return new ResponseEntity<>(modelService.getByName(identifier),HttpStatus.OK);
        }
    }
}
