package org.example.eventsbookingsystem.entity;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Scope("prototype")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id private long id;
    private String name;
    private String description;
    private String typeOfEvents;
    private int defaultEventCapacity;
}