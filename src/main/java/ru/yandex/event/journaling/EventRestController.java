package ru.yandex.event.journaling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.yandex.event.journaling.dto.EventDTO;
import ru.yandex.event.journaling.service.EventJournaling;
import ru.yandex.event.journaling.service.TestEventJournaling;

@RestController
public class EventRestController {

    @Autowired
    private TestEventJournaling testJournaling;

    @Autowired
    private EventJournaling journaling;

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public ResponseEntity<List<EventDTO>> generate(int numberOfEvents) {
        List<EventDTO> entities = testJournaling.generateEvents(numberOfEvents);
        return new ResponseEntity<List<EventDTO>>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.POST)
    public ResponseEntity<String> deleteAll() {
        journaling.deleteAllEventsFromRepository();
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
