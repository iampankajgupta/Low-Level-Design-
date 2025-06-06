package LLD.SplitWise.ExpFactory;

import LLD.SplitWise.Split;

import java.util.List;

public interface ExpenseValidator {
    public boolean validate(double amount, List<Split> participants);
}
