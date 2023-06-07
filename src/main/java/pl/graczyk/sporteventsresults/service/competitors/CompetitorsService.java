package pl.graczyk.sporteventsresults.service.competitors;

import pl.graczyk.sporteventsresults.dto.CompetitorDTO;
import pl.graczyk.sporteventsresults.dto.EventDTO;
import pl.graczyk.sporteventsresults.model.Competitor;

import java.util.List;

public interface CompetitorsService {

    List<CompetitorDTO> getAllTeams();
}
