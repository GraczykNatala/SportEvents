package pl.graczyk.sporteventsresults.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    String sport_event_id;
    String start_date;
    String sport_name;
    String competition_name;
    String competition_id;
    String season_name;
    Competitor[] competitors;
    Venue venue;
    double probability_home_team_winner;
    double probability_draw;
    double probability_away_team_winner;


}

