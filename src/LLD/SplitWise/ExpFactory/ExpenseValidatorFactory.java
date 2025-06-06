package LLD.SplitWise.ExpFactory;

import LLD.SplitWise.ExpenseType;

public class ExpenseValidatorFactory{

    private static final ExpenseValidator EQUAL_VALIDATOR = new Equal();
    private static final ExpenseValidator UNEQUAL_VALIDATOR = new UnEqual();
    private static final ExpenseValidator PERCENTAGE_VALIDATOR = new Percentage();

    public static ExpenseValidator getValidator(ExpenseType type) {
        // Option 1
        return switch (type) {
            case EQUAL -> EQUAL_VALIDATOR;
            case UNEQUAL -> UNEQUAL_VALIDATOR;
            case PERCENTAGE -> PERCENTAGE_VALIDATOR;
        };
    }
}
