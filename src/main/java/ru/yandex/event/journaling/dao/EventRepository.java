package ru.yandex.event.journaling.dao;

import java.util.List;

public interface EventRepository {

    void create(Event event);

    List<Event> findAll();

    void deleteAll();
}