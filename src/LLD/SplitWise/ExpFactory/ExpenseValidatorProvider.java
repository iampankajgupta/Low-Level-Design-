package LLD.SplitWise.ExpFactory;

import LLD.SplitWise.ExpenseType;

public interface ExpenseValidatorProvider {
    ExpenseValidator getValidator(ExpenseType type);
}
