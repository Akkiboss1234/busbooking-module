package com.busbookingreservation.repository;

import com.busbookingreservation.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
