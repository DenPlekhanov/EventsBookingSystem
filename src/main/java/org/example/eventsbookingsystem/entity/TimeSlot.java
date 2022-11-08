package org.example.eventsbookingsystem.entity;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Scope("prototype")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "timeslot")
public class TimeSlot {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;
    @Column(name = "event_id")
    private long eventId = 0; //TODO Дефолтное значение 0 значит что событие не привязано. Хорошо бы оставить null но тогда падает. Надо разобраться.
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date finishDate;
    @Column(name = "place_id")
    private long placeId;
    @Transient
    private Place place; //TODO переписать геттер placeId чтобы дописывал поле place, либо вообще убрать поле

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", placeId=" + placeId +
                ", place=" + place +
                '}';
    }
}
