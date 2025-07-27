package LLD.TransactionFilteringSystem.OperatorType;

public class OperatorService {
    private OperatorType operatorType;

    public OperatorService(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(OperatorType operatorType) {
        this.operatorType = operatorType;
    }
}
