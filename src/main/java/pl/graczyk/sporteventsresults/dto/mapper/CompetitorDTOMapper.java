package pl.graczyk.sporteventsresults.dto.mapper;

import org.springframework.stereotype.Component;
import pl.graczyk.sporteventsresults.dto.CompetitorDTO;
import pl.graczyk.sporteventsresults.model.Competitor;

import java.util.function.Function;

@Component
public class CompetitorDTOMapper implements Function<Competitor, CompetitorDTO> {


    @Override
    public CompetitorDTO apply(Competitor competitor) {
        return new CompetitorDTO(
                competitor.getName(),
                competitor.getCountry()
        );
    }
}





