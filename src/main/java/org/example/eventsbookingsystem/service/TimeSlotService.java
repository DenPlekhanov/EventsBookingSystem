package org.example.eventsbookingsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.eventsbookingsystem.entity.TimeSlot;
import org.example.eventsbookingsystem.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TimeSlotService {
    private final TimeSlotRepository repository;

    public List<TimeSlot> getAll() {
        return repository.findAll();
    }

    public TimeSlot getById(long id) {
        return repository.getReferenceById(id);
    }

    public List<TimeSlot> findAllByPlaceIdOrderByStartDate (long placeId) {
        return repository.findAllByPlaceIdOrderByStartDate(placeId);
    }

    public List<TimeSlot> findAllVacantSlotsByPlaceIdOrderByStartDate (long placeId) {
        return repository.findAllByPlaceIdAndEventIdEquals(placeId, 0); //0 - мероприятие не назначено.
    }

//    public List<TimeSlot> findAllPartiallyOccupiedSlotsByPlaceIdOrderByStartDate (long placeId) {
//        return repository.

    public void /*List<TimeSlot>*/ splitTimeSlot(long slotToSplitId, Date newSlotStartDate, Date newSlotFinishDate) {
        //TODO Добавить валидацию
        TimeSlot sourceTimeSlot = repository.getReferenceById(slotToSplitId);
        List<TimeSlot> newTimeSlotsList = new ArrayList<>();
        TimeSlot newBeforeTimeSlot = null;
        TimeSlot newMediumTimeSlot = null;
        TimeSlot newAfterTimeSlot = null;

        System.out.println("Перед if-ами");//
        System.out.println("ID : " + slotToSplitId);
        System.out.println("Start : " + newSlotStartDate);
        System.out.println("Finish : " + newSlotFinishDate);
        System.out.println(sourceTimeSlot.getStartDate());
        System.out.println(sourceTimeSlot.getFinishDate());
        System.out.println("Перед if-ами2");//


        if (sourceTimeSlot.getStartDate().getTime() == newSlotStartDate.getTime()
                && sourceTimeSlot.getFinishDate().after(newSlotFinishDate)) {
            System.out.println("Var1");//

            newBeforeTimeSlot = TimeSlot.builder()
                    .startDate(newSlotStartDate)
                    .finishDate(newSlotFinishDate)
                    .placeId(sourceTimeSlot.getPlaceId())
                    .build();
            sourceTimeSlot.setStartDate(newSlotFinishDate);
            newTimeSlotsList.add(newBeforeTimeSlot);
            newTimeSlotsList.add(sourceTimeSlot);

        } else if (sourceTimeSlot.getStartDate().before(newSlotStartDate)
                && sourceTimeSlot.getFinishDate().after(newSlotFinishDate)) {
            System.out.println("Var2");//

            newMediumTimeSlot = TimeSlot.builder()
                    .startDate(newSlotStartDate)
                    .finishDate(newSlotFinishDate)
                    .placeId(sourceTimeSlot.getPlaceId())
                    .build();
            newAfterTimeSlot = TimeSlot.builder()
                    .startDate(newSlotFinishDate)
                    .finishDate(sourceTimeSlot.getFinishDate())
                    .placeId(sourceTimeSlot.getPlaceId())
                    .build();
            sourceTimeSlot.setFinishDate(newSlotStartDate);
            newTimeSlotsList.add(sourceTimeSlot);
            newTimeSlotsList.add(newMediumTimeSlot);
            newTimeSlotsList.add(newAfterTimeSlot);
        } else if (sourceTimeSlot.getStartDate().before(newSlotStartDate)
                && sourceTimeSlot.getFinishDate().getTime() == newSlotFinishDate.getTime()) {
            System.out.println("Var3");//

            newAfterTimeSlot = TimeSlot.builder()
                    .startDate(newSlotStartDate)
                    .finishDate(newSlotFinishDate)
                    .placeId(sourceTimeSlot.getPlaceId())
                    .build();
            sourceTimeSlot.setFinishDate(newSlotStartDate);
            newTimeSlotsList.add(sourceTimeSlot);
            newTimeSlotsList.add(newAfterTimeSlot);
        }
        saveOrUpdate(newTimeSlotsList);
        repository.flush();
    }

    public List<TimeSlot> saveOrUpdate(List<TimeSlot> timeSlotsListToSaveOrUpdate) {
        return repository.saveAll(timeSlotsListToSaveOrUpdate);
    }

    public TimeSlot saveOrUpdate(TimeSlot timeSlotToSaveOrUpdate) {
        return repository.save(timeSlotToSaveOrUpdate);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}