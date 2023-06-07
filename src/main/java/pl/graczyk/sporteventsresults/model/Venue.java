package pl.graczyk.sporteventsresults.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Venue {
    String id;
    String name;
    int capacity;
    String city_name;
    String country_name;
    String map_coordinates;
    String country_code;


}
