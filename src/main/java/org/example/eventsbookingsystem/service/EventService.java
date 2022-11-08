package org.example.eventsbookingsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.eventsbookingsystem.entity.Event;
import org.example.eventsbookingsystem.repository.EventRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {
    private final EventRepository repository;

    public List<Event> getAll() {
        return repository.findAll();
    }

    public Event getById(long id) {
        return repository.getReferenceById(id);
    }
}