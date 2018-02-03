package ru.yandex.event.journaling.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.yandex.event.journaling.dao.Event;
import ru.yandex.event.journaling.dao.EventRepository;
import ru.yandex.event.journaling.dto.EventDTO;

@Service
public class EventJournalingService implements EventJournaling {

    @Autowired
    private EventRepository repository;

    @Override
    public void journalEvent(long id, String name, LocalDateTime date) {
        repository.create(new Event(id, name, date));
    }

    @Override
    public List<EventDTO> getEventsOccurInOneMinute() {
        LocalDateTime earlyDate = LocalDateTime.now().minusMinutes(1L);
        return getEventsAfter(earlyDate);
    }

    @Override
    public List<EventDTO> getEventsOccurInOneHour() {
        LocalDateTime earlyDate = LocalDateTime.now().minusHours(1L);
        return getEventsAfter(earlyDate);
    }

    @Override
    public List<EventDTO> getEventsOccurInOneDay() {
        LocalDateTime earlyDate = LocalDateTime.now().minusDays(1L);
        return getEventsAfter(earlyDate);
    }

    @Override
    public List<EventDTO> getEventsAfter(LocalDateTime earlyDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return getEvents()
                .stream()
                .filter(event -> event.getDate().isAfter(earlyDate))
                .map(event -> new EventDTO(
                            event.getId(),
                            event.getName(),
                            event.getDate().format(formatter))
                )
                .collect(Collectors.toList());
    }

    private List<Event> getEvents() {
        return repository.findAll();
    }

    @Override
    public void deleteAllEventsFromRepository() {
        repository.deleteAll();
    }
}
