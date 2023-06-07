package pl.graczyk.sporteventsresults.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO implements Comparable<EventDTO> {

    String start_date;
    String venue;
    List<CompetitorDTO> competitors;
    String highestProbableResultName;

    @JsonIgnore
    double highestProbableResult;


    @Override
    public int compareTo(EventDTO event) {
            if(highestProbableResult < event.highestProbableResult) {
                return 1;
            }
            else if(highestProbableResult > event.highestProbableResult) {
                return -1;
            }
            return 0;

    }
}




