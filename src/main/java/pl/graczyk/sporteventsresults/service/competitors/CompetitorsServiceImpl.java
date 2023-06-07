package pl.graczyk.sporteventsresults.service.competitors;

import org.springframework.stereotype.Service;
import pl.graczyk.sporteventsresults.dto.CompetitorDTO;
import pl.graczyk.sporteventsresults.dto.EventDTO;
import pl.graczyk.sporteventsresults.service.events.EventsService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class CompetitorsServiceImpl implements CompetitorsService {

    private final EventsService eventsService;

    public CompetitorsServiceImpl(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @Override
    public List<CompetitorDTO> getAllTeams() {
        List<EventDTO> events = eventsService.getAllEvents();

        Set<CompetitorDTO> competitors = new HashSet<>();
                events.forEach(event -> competitors.addAll(event.getCompetitors()));


        return competitors.stream().sorted().collect(Collectors.toList());
    }

    }
