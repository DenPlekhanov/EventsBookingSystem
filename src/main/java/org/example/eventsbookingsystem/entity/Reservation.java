package org.example.eventsbookingsystem.entity;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Component
@Scope("prototype")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id private long id;
    private long eventId;
    private Date dateOfReservation;
    private int amountOfPeople;
    @Transient private List<Participant> participantList;
}
