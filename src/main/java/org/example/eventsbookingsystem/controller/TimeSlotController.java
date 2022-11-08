package org.example.eventsbookingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.eventsbookingsystem.entity.TimeSlot;
import org.example.eventsbookingsystem.service.TimeSlotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/timeslots")
@RequiredArgsConstructor
public class TimeSlotController {
    private static final Logger logger = LoggerFactory.getLogger(TimeSlotController.class); //TODO добавить логирование в каждый метод.
    private final TimeSlotService service;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("timeslots", service.getAll());
        return "timeslots/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("timeslot", service.getById(id));
        return "timeslots/timeslot";
    }

    @GetMapping ("/{id}/split-timeslot")
    public String splitTimeSlot (Model model, @PathVariable("id") long id){
        model.addAttribute("timeslot", service.getById(id));
        return "timeslots/split-timeslot";
    }

    @PutMapping ("/{id}")
    public String splitTimeslot(@ModelAttribute("timeslot") TimeSlot timeSlot, @PathVariable("id") long slotToSplitId, @ModelAttribute("startdate") Date startDate2, @ModelAttribute("finishdate") Date finishDate2) {
        //TODO Разобраться с аннотациями @ModelAttribute и @PathVariable
        //TODO В startDate и finishDate почему-то приходит текущее время. (парсер через аннотацию в сущности не справляется?!)

        Date startDate = timeSlot.getStartDate();
        Date finishDate = timeSlot.getFinishDate();
        service.splitTimeSlot(slotToSplitId, startDate, finishDate);
        return "redirect:/timeslots";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id){
        service.deleteById(id);
        return "redirect:/timeslots";
    }

    @GetMapping("vacant-timeslots")
    public String vacantTimeSlotsIndex (Model model, @RequestParam(value = "placeId", required = false, defaultValue = "6") long placeId) {
        //TODO Убрать хардкод id = 6
        model.addAttribute("timeslots", service.findAllVacantSlotsByPlaceIdOrderByStartDate(placeId));
        return "timeslots/vacant-timeslots";
    }
}