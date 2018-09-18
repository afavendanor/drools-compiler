package co.com.suramericana.domain;

public class Parameter {

    private String codeRule;
    private String conditionsList;
    private String conditionType;
    private String actions;
    private String firstRow;


    public Parameter(String codeRule, String conditionsList, String conditionType, String actions, String firstRow) {
        this.codeRule = codeRule;
        this.conditionsList = conditionsList;
        this.conditionType = conditionType;
        this.actions = actions;
        this.firstRow = firstRow;
    }

    public String getCodeRule() {
        return codeRule;
    }

    public String getConditionsList() {
        return conditionsList;
    }

    public String getConditionType() {
        return conditionType;
    }

    public String getActions() {
        return actions;
    }

    public String getFirstRow() {
        return firstRow;
    }

}
