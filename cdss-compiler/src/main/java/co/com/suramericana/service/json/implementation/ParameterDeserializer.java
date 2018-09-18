package co.com.suramericana.service.json.implementation;

import co.com.suramericana.domain.Action;
import co.com.suramericana.domain.Condition;
import co.com.suramericana.domain.Parameter;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParameterDeserializer implements JsonDeserializer<List<Parameter>> {

    private static final String TAG_METADATA = "metadatos";
    private static final String TAG_CODE = "codigo";
    private static final String GROUP_CONDITION = "GroupCondition";
    private static final String SIMPLE_CONDITION = "SimpleCondition";
    private static final String TAG_CONDITIONS = "condiciones";
    private static final String TAG_ACTIONS = "acciones";
    private static final String SEPARATOR = " && ";

    @Override
    public List<Parameter> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        final List<Parameter> parameters = new ArrayList<>();
        final Gson gson = new Gson();
        String ruleCode = "";
        String conditionType;
        String actions = "";
        String lastRow = "false";
        String firstRow = "true";

        final JsonObject ruleObject = json.getAsJsonObject();

        if (ruleObject.has(TAG_METADATA)) {
            final JsonObject objectMetadata = ruleObject.get(TAG_METADATA).getAsJsonObject();
            ruleCode = objectMetadata.get(TAG_CODE).getAsString();
        }

        if (ruleObject.has(TAG_ACTIONS)) {
            final JsonArray arrayActions = ruleObject.get(TAG_ACTIONS).getAsJsonArray();
            Type listAction = new TypeToken<List<Action>>() { }.getType();
            actions = convertString(gson.fromJson(arrayActions, listAction), ",");
        }

        JsonArray jsonArray;
        if (ruleObject.has(TAG_CONDITIONS)) {
            jsonArray = ruleObject.get(TAG_CONDITIONS).getAsJsonArray();

            for (int i = 0; i < jsonArray.size(); i++) {
                final JsonElement condition = jsonArray.get(i);
                final JsonArray conditionsArray = condition.getAsJsonArray();

                if(i > 0) {
                    firstRow = "false";
                }

                if (conditionsArray.size() > 1) {
                    conditionType = GROUP_CONDITION;
                } else {
                    conditionType = SIMPLE_CONDITION;
                }
                if(i == jsonArray.size() - 1) {
                    lastRow = actions;
                }
                Type listRuleType = new TypeToken<List<Condition>>() {}.getType();

                parameters.add(new Parameter(ruleCode, convertString(gson.fromJson(conditionsArray, listRuleType),
                        SEPARATOR), conditionType, lastRow, firstRow));
            }
        }
        return parameters;
    }


    private <T> String convertString(List<T> elementList, String separator) {
        final StringBuilder statementBuilder = new StringBuilder();
        for (Iterator<T> iterator = elementList.iterator(); iterator.hasNext();) {
            final T element = iterator.next();
            if(element instanceof Condition) {
                statementBuilder.append("Dato").append("(").append(element.toString()).append(")");
            } else if (element instanceof Action){
                statementBuilder.append("\"").append(element.toString()).append("\"");
            }
            if(iterator.hasNext()) {
                statementBuilder.append(separator).append("\n");
            }
        }
        return statementBuilder.toString();
    }
}
