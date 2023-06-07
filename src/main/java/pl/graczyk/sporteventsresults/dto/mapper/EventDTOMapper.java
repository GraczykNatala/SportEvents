package pl.graczyk.sporteventsresults.dto.mapper;

import org.springframework.stereotype.Component;
import pl.graczyk.sporteventsresults.dto.CompetitorDTO;
import pl.graczyk.sporteventsresults.dto.EventDTO;
import pl.graczyk.sporteventsresults.model.Event;
import pl.graczyk.sporteventsresults.model.Venue;
import pl.graczyk.sporteventsresults.utils.MostProbableResultUtil;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class EventDTOMapper implements Function<Event, EventDTO> {

    private final MostProbableResultUtil mostProbableResultUtil;

    public EventDTOMapper(MostProbableResultUtil mostProbableResultUtil) {
        this.mostProbableResultUtil = mostProbableResultUtil;
    }

    @Override
    public EventDTO apply(Event event) {

        String venueName;
        if(event.getVenue() != null) {
            Venue venue = event.getVenue();
            venueName = venue.getName();
        } else {
            venueName = "No data";}

        return new EventDTO(
                event.getStart_date(),
                venueName,
                Arrays.stream(event.getCompetitors()).map(competitor-> new CompetitorDTO(
                        competitor.getName(),
                        competitor.getCountry()
                )).collect(Collectors.toList()),
                mostProbableResultUtil.highestProbableResult(event),
                mostProbableResultUtil.findHighestProbabiility(event)

        );
    }

}
