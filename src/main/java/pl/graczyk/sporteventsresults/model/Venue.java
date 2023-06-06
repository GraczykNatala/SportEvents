package pl.graczyk.sporteventsresults.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
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
    String map_coordintes;
    String country_code;

}
