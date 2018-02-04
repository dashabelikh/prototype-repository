package ru.yandex;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ru.yandex.event.journaling.dao.EventRepository;
import ru.yandex.event.journaling.service.TestEventJournaling;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private EventRepository repository;

    @Autowired
    private TestEventJournaling testJournaling;

    @Test
    public void contextLoads() {
    }

    @Test
    public void writeAndRead() {
        int numberOfEvents = 1500;
        testJournaling.generateEvents(numberOfEvents);
        assertTrue(numberOfEvents == repository.findAll().size());

    }
}
