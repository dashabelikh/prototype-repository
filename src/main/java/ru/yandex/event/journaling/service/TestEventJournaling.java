package ru.yandex.event.journaling.service;

import java.util.List;

import ru.yandex.event.journaling.dto.EventDTO;

public interface TestEventJournaling {

    List<EventDTO> generateEvents(int numberOfEvents);

}
