package pl.graczyk.sporteventsresults.service.events;

import pl.graczyk.sporteventsresults.dto.EventDTO;

import java.util.List;

public interface EventsService {


    List<EventDTO> getEventsWithGivenTeam(String teamName);

    List<EventDTO> getAllEvents();

    List<EventDTO> getAllEventsSorted();
    List<EventDTO> getAllEventsSortedAndLimited(int amount);
}
