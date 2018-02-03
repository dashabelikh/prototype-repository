package ru.yandex.event.journaling.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.yandex.event.journaling.dao.Event;
import ru.yandex.event.journaling.dao.EventRepository;
import ru.yandex.event.journaling.dto.EventDTO;

@Service
public class TestEventJournalingService implements TestEventJournaling {

    @Autowired
    private EventRepository repository;

    public List<EventDTO> generateEvents(int numberOfEvents) {
        IntStream.range(1, numberOfEvents + 1)
                .mapToObj(number -> new Event(
                        number,
                        "event-" + number, 
                        LocalDateTime.now()
                    )
                )
                .forEach(event -> repository.create(event));
        return Collections.emptyList();
    }
}
