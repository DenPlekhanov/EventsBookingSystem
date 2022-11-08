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
public class Participant {
    @Id private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
