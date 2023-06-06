package pl.graczyk.sporteventsresults.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import pl.graczyk.sporteventsresults.model.Event;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class DataReader {

    public static final String DATA_PATH = "src/main/resources/data/data.json";

    public List<Event> eventList() throws FileNotFoundException {

        JsonParser parser = new JsonParser();
        Object obj =parser.parse(new FileReader(DATA_PATH)) ;
        JsonObject jsonObject = (JsonObject) obj;
        JsonArray eventData = (JsonArray) jsonObject.get("Events");
        return new Gson().fromJson(eventData, new TypeToken<List<Event>>(){}.getType());
    }
}
