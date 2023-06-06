package pl.graczyk.sporteventsresults.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.graczyk.sporteventsresults.model.Event;
import pl.graczyk.sporteventsresults.utils.DataReader;

import java.io.FileNotFoundException;
import java.util.List;



@RestController
public class MatchResultsController {

    @Autowired
    private final DataReader dataReader;

    public MatchResultsController(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    @GetMapping("/results")
    private List<Event> getListOfEvents() throws FileNotFoundException {
        List<Event> events = dataReader.eventList();
        return events;
    }
}
