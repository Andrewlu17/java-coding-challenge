package com.mooveit.cars.repositories;

import com.mooveit.cars.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {

    List<Model> findByName(String name);
}
