package pl.graczyk.sporteventsresults.utils;

import org.springframework.stereotype.Service;
import pl.graczyk.sporteventsresults.model.Event;

@Service
public class MostProbableResultUtil {

    public static final String HOME = "HOME TEAM WIN";
    public static final String DRAW = "DRAW";
    public static final String AWAY = "AWAY";
    public String highestProbableResult(Event event) {
        double highestProbableResult = findHighestProbabiility(event);
        String highestProbableResultName = null;
        if(event.getProbability_home_team_winner() == highestProbableResult) {
            highestProbableResultName = HOME;
        }
        else if(event.getProbability_draw() == highestProbableResult) {
            highestProbableResultName = DRAW;
        }
        else if(event.getProbability_away_team_winner() == highestProbableResult) {
            highestProbableResultName = AWAY;
        }
        return highestProbableResultName + " (" + highestProbableResult + ")";
    }
    public double findHighestProbabiility(Event event) {
        return Math.max(event.getProbability_draw(),
                        Math.max(event.getProbability_away_team_winner(),
                                 event.getProbability_home_team_winner()));
    }
}
