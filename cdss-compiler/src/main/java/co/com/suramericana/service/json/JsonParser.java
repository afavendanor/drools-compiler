package co.com.suramericana.service.json;

import co.com.suramericana.domain.Parameter;

import java.util.List;

public interface JsonParser {

    List<Parameter> stringToParameters(String jsonFile);
}
