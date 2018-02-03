package ru.yandex.event.journaling;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.yandex.event.journaling.dto.EventDTO;
import ru.yandex.event.journaling.service.EventJournaling;

@Controller
public class HomeController {

    @Autowired
    private EventJournaling journaling;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        model.addAttribute("requestMessage", "all events in database");
        model.addAttribute("events", journaling.getEventsOccurInOneDay());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, params = "time")
    public String showEventsOccurInOneMinute(
            @RequestParam("time") String time,
            Model model
    ) {
        List<EventDTO> events;
        switch (time) {
        case "minute":
            events = journaling.getEventsOccurInOneMinute();
            break;
        case "hour":
            events = journaling.getEventsOccurInOneHour();
            break;
        case "day":
            events = journaling.getEventsOccurInOneDay();
            break;
        default:
            events = new ArrayList<>();
        }
        model.addAttribute("requestMessage", "all events in 1 " + time);
        model.addAttribute("events", events);
        return "index";
    }

}
