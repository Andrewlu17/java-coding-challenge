package com.mooveit.cars.repositories;

import com.mooveit.cars.domain.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<Engine,Long> {
}
