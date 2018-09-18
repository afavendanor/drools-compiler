package co.com.suramericana.domain;

import co.com.suramericana.service.Operators;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

public class Condition {
    private static final int BASIC_CONDITION = 1;
    private static final int ARRAY_CONDITION = 2;

    @SerializedName("cod_var")
    private String codeVariable;

    @SerializedName("des_var")
    private String descriptionVariable;

    @SerializedName("sis_var")
    private Object systemVariable;

    @SerializedName("ope_val")
    private String operatorValue;

    @SerializedName("cod_val")
    private Object codeValue;

    @SerializedName("des_val")
    private String descriptionValue;

    @SerializedName("sis_val")
    private String systemValue;

    @SerializedName("ope_fec")
    private String operatorDate;

    @SerializedName("dias")
    private String amountDays;

    @SerializedName("contexto")
    private String context;

    @SerializedName("des_ctx")
    private String descriptionContext;


    @Override
    public String toString() {
        final String codVarKey = "cod_var";
        final String sisVarKey = "sis_var";
        final String codValKey = "cod_val";
        final String sisValKey = "sis_val";
        final String equalsOperator = " == ";
        final String containsOperator = " contains ";
        final String comma = ", ";
        final StringBuilder statementBuilder = new StringBuilder();

        //codeVariable
        statementBuilder.append(buildCondition(codVarKey, codeVariable, equalsOperator, BASIC_CONDITION)).append(comma);
        //systemVariable
        statementBuilder.append(buildCondition(sisVarKey, systemVariable.toString(), equalsOperator, BASIC_CONDITION)).append(comma);
        //codeValue
        if (codeValue instanceof Array) {
            statementBuilder.append(
                    buildCondition(codValKey, codeValue.toString(), Operators.getValue(operatorValue), ARRAY_CONDITION)).append(comma);
        } else {
            statementBuilder.append(
                    buildCondition(codValKey, codeValue.toString(), Operators.getValue(operatorValue), BASIC_CONDITION)).append(comma);
        }
        //systemValue
        statementBuilder.append(buildCondition(sisValKey, codeValue.toString(), equalsOperator, BASIC_CONDITION)).append(comma);
        //context
        statementBuilder.append(buildCondition("contexto", context, containsOperator, BASIC_CONDITION));

        return statementBuilder.toString();
    }

    private String buildCondition(String key, String value, String operator, int type) {
        final StringBuilder basicCondition = new StringBuilder();
        switch (type) {
            case BASIC_CONDITION:
                basicCondition.append(key).append(operator)
                        .append("'").append(value).append("'");
                break;
            case ARRAY_CONDITION:
                basicCondition.append(key).append(operator)
                        .append("(").append(value).append(") ");
                break;
            default:
                break;
        }
        return basicCondition.toString();
    }
}
