package pl.graczyk.sporteventsresults.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.graczyk.sporteventsresults.dto.EventDTO;
import pl.graczyk.sporteventsresults.service.events.EventsService;
import java.util.List;


@RestController
@RequestMapping(path = "/events")
public class MatchResultsController {
    private final EventsService service;

    public MatchResultsController(EventsService matchResultsService) {
        this.service = matchResultsService;
    }

    @GetMapping(value = {"", "/{amount}"})
    public ResponseEntity<List<EventDTO>> getListOfEvents(@PathVariable(required = false)  Integer amount) {
      List<EventDTO> listOfEvents;
        if(null != amount) {
            listOfEvents = service.getAllEventsSortedAndLimited(amount);
        } else {
            listOfEvents =  service.getAllEventsSorted();
        }
        return new ResponseEntity<>(listOfEvents, HttpStatus.OK);
    }

    @GetMapping(value = { "/teams/{teamName}"})
    public ResponseEntity<List<EventDTO>> getListOfEventsofTeam(@PathVariable String teamName) {
        List<EventDTO> listOfEvents = service.getEventsWithGivenTeam(teamName);
        return new ResponseEntity<>(listOfEvents, HttpStatus.OK);
    }
}
