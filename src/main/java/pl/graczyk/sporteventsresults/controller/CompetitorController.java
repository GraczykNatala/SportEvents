package pl.graczyk.sporteventsresults.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.graczyk.sporteventsresults.dto.CompetitorDTO;
import pl.graczyk.sporteventsresults.dto.EventDTO;
import pl.graczyk.sporteventsresults.service.competitors.CompetitorsService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/teams")
public class CompetitorController {

    private final CompetitorsService service;

    public CompetitorController(CompetitorsService service) {
        this.service = service;
    }


    @GetMapping("")
    public ResponseEntity<List<CompetitorDTO>> getListOfCompetitors()  {
        List<CompetitorDTO> teams = service.getAllTeams();
     return new ResponseEntity<>(teams, HttpStatus.OK);
    }

}
