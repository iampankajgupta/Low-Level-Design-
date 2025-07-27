package SplitWise;

import LLD.SplitWise.ExpFactory.Equal;
import LLD.SplitWise.ExpFactory.ExpenseValidator;
import LLD.SplitWise.ExpFactory.Percentage;
import LLD.SplitWise.ExpFactory.UnEqual;
import LLD.SplitWise.ExpenseType;
import SplitWise.strategy.EqualSplitStrategy;

public class ExpenseValidatorFactory{

    //private static final LLD.SplitWise.ExpFactory.ExpenseValidator EQUAL_VALIDATOR = new EqualSplitStrategy();
    private static final LLD.SplitWise.ExpFactory.ExpenseValidator UNEQUAL_VALIDATOR = new UnEqual();
    private static final LLD.SplitWise.ExpFactory.ExpenseValidator PERCENTAGE_VALIDATOR = new Percentage();

    public static ExpenseValidator getValidator(ExpenseType type) {
        return null; // for now returning null please revert
        /*
        // Option 1
        return switch (type) {
            //case EQUAL -> EQUAL_VALIDATOR;
            case UNEQUAL -> UNEQUAL_VALIDATOR;
            case PERCENTAGE -> PERCENTAGE_VALIDATOR;
        };

         */
    }
}
