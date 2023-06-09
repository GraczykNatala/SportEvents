package pl.graczyk.sporteventsresults.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Competitor {
    String id;
    String name;
    String country;
    String country_code;
    String abbreviation;
    String qualifier;
    String gender;

}
