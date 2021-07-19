package com.mooveit.cars.repositories;

import com.mooveit.cars.domain.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelRepository extends JpaRepository<Wheel,Long> {
}
