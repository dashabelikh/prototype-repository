package ru.yandex.event.journaling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.yandex.event.journaling.service.EventJournaling;

@Controller
public class HomeController {

    @Autowired
    private EventJournaling journaling;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        model.addAttribute("requestMessage", "all events in database");
        model.addAttribute("events", journaling.getEventsHappendsInDay());
        return "index";
    }

    // @RequestMapping(value = "/show", method = RequestMethod.GET)
    // public String showEvents(Model model) {
    // model.
    // return "index";
    // }
}
