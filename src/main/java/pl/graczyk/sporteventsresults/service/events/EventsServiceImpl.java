package pl.graczyk.sporteventsresults.service.events;

import org.springframework.stereotype.Service;
import pl.graczyk.sporteventsresults.dto.EventDTO;
import pl.graczyk.sporteventsresults.dto.mapper.EventDTOMapper;
import pl.graczyk.sporteventsresults.utils.DataReader;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventsServiceImpl implements EventsService {

    private final DataReader dataReader;
    //  private final MostProbableResultUtil mostProbableResultUtil;
    private final EventDTOMapper eventDTOMapper;

    public EventsServiceImpl(DataReader dataReader, EventDTOMapper eventDTOMapper) {
        this.dataReader = dataReader;
        this.eventDTOMapper = eventDTOMapper;
    }

    @Override
    public List<EventDTO> getEventsWithGivenTeam(String teamName) {
        return getAllEvents().stream()
                .filter(event -> event.getCompetitors()
                        .stream()
                        .anyMatch(competitor -> competitor.getName()
                                .equals(teamName)))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return dataReader.eventList()
                .stream()
                .map(eventDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getAllEventsSorted() {
        return getAllEvents().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getAllEventsSortedAndLimited(int amount) {
        return getAllEventsSorted().stream()
                .limit(amount)
                .collect(Collectors.toList());

    }
}

