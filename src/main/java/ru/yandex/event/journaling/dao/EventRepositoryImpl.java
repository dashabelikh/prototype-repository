package ru.yandex.event.journaling.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
class EventRepositoryImpl implements EventRepository {

    private static final List<Event> events = new ArrayList<>();

    @Override
    public void create(Event event) {
        events.add(event);
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public void deleteAll() {
        events.clear();
    }
}