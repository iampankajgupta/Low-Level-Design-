package LLD.TransactionFilteringSystem;

import LLD.TransactionFilteringSystem.OperatorType.OperatorService;
import LLD.TransactionFilteringSystem.OperatorType.OperatorType;

public class FilterCriteria<T> {

    private String field;
    private String value;
    private String operatorType;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }
}
