package ru.yandex.event.journaling.service;

import java.time.LocalDateTime;
import java.util.List;

import ru.yandex.event.journaling.dto.EventDTO;

public interface EventJournaling {

    void journalEvent(long id, String name, LocalDateTime date);

    List<EventDTO> getEventsOccurInOneMinute();

    List<EventDTO> getEventsOccurInOneHour();

    List<EventDTO> getEventsOccurInOneDay();

    List<EventDTO> getEventsAfter(LocalDateTime earlyDate);

    void deleteAllEventsFromRepository();

}
