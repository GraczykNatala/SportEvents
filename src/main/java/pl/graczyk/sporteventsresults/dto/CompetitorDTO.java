package pl.graczyk.sporteventsresults.dto;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompetitorDTO implements Comparable<CompetitorDTO> {

    String name;
    String country;


    @Override
    public int compareTo(CompetitorDTO competitor) {
        return this.name.compareTo(competitor.name);
    }
}
