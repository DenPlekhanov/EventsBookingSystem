package org.example.eventsbookingsystem.entity;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Component
@Scope("prototype")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id private long id;
    private String eventName;
    private String eventDescription;
    @Transient private List<Reservation> reservationList;
    @Transient private TimeSlot timeSlot;
    @Transient private List<Staff> staffList;
    private int eventCapacity;
}