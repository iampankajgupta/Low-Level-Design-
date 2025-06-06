package LLD.SplitWise.ExpFactory;

import LLD.SplitWise.Split;

import java.util.List;

public class Equal implements ExpenseValidator {
    @Override
    public boolean validate(double amount, List<Split> participants) {
        return false;
    }
}
