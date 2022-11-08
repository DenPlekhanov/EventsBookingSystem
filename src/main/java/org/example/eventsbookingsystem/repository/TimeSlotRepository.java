package org.example.eventsbookingsystem.repository;

import org.example.eventsbookingsystem.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSlotRepository  extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findAllByPlaceIdOrderByStartDate (long placeId);
    List<TimeSlot> findAllByPlaceIdAndEventIdEquals (long placeId, long eventId);
}