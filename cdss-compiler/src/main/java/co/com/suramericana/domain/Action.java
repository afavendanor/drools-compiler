package co.com.suramericana.domain;

import com.google.gson.annotations.SerializedName;

public class Action {

    @SerializedName("tipo")
    private String type;

    @SerializedName("descripcion")
    private String description;

    public Action(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        final StringBuilder statementBuilder = new StringBuilder();
        statementBuilder.append(type).append(description);
        return statementBuilder.toString();
    }
}
