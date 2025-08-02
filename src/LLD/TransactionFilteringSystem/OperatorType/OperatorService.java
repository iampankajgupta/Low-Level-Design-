package LLD.TransactionFilteringSystem.OperatorType;

public class OperatorService {
    private OperatorType1 operatorType;

    public OperatorService(OperatorType1 operatorType) {
        this.operatorType = operatorType;
    }

    public OperatorType1 getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(OperatorType1 operatorType) {
        this.operatorType = operatorType;
    }
}
