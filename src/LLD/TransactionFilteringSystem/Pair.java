package LLD.TransactionFilteringSystem;

public class Pair<T> {
    private T field;
    private String operator;

    Pair(T field, String operator) {
        this.field = field;
        this.operator = operator;
    }


    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
