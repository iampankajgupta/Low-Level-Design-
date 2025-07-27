package SplitWise;

import LLD.SplitWise.Split;

import java.util.List;

public interface ExpenseValidator {
    public boolean validate(double amount, List<SplitWise.Split> participants);
}
