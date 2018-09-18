package co.com.suramericana.service.json.implementation;

import co.com.suramericana.domain.Parameter;
import co.com.suramericana.service.json.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class JsonParserImpl implements JsonParser {

    @Override
    public List<Parameter> stringToParameters(String jsonFile) {
        final GsonBuilder builder = new GsonBuilder();
        final Type type = new TypeToken<List<Parameter>>(){}.getType();
        builder.registerTypeAdapter(type, new ParameterDeserializer());
        final Gson gson = builder.create();
        return gson.fromJson(jsonFile, type);
    }
}
