package co.com.suramericana.service;

public class Operators {

    private static final String EQUAL_OPERATOR = "igual";
    private static final String GREATER_THAN_OPERATOR = "mayor";
    private static final String GREATER_THAN_OR_EQUAL_OPERATOR = "mayor_igual";
    private static final String LESS_THAN_OPERATOR = "menor";
    private static final String LESS_THAN_OR_EQUAL_OPERATOR = "menor_igual";
    private static final String DOES_NOT_HAVE_LESS_THAN_OPERATOR = "no_tenga_menos";
    private static final String DOES_NOT_HAVE_GREATER_THAN_OPERATOR = "no_tenga_mayor";

    private Operators() {}

    public static final String getValue(String operator) {
        switch (operator) {
            case EQUAL_OPERATOR:
                operator = " == ";
                break;
            case GREATER_THAN_OPERATOR:
                operator = " > ";
                break;
            case GREATER_THAN_OR_EQUAL_OPERATOR:
                operator = " >= ";
                break;
            case LESS_THAN_OPERATOR:
                operator = " < ";
                break;
            case LESS_THAN_OR_EQUAL_OPERATOR:
                operator = " <= ";
                break;
            case DOES_NOT_HAVE_LESS_THAN_OPERATOR:
                operator = " >= ";
                break;
            case DOES_NOT_HAVE_GREATER_THAN_OPERATOR:
                operator = " <= ";
                break;
            default:
                break;
        }
        return operator;
    }
}
