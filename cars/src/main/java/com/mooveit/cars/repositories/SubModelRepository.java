package com.mooveit.cars.repositories;

import com.mooveit.cars.domain.SubModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubModelRepository extends JpaRepository<SubModel,Long> {
}
