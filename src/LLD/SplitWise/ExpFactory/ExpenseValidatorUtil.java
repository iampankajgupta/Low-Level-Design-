package LLD.SplitWise.ExpFactory;

import LLD.SplitWise.Expense;
import LLD.SplitWise.ExpenseType;
import LLD.SplitWise.Split;

import java.util.List;


// This is not valid it violates Single Responsibility Principle, Open Close Principle
public class ExpenseValidatorUtil {

    public boolean validate(ExpenseType expenseType, double amount, List<Split> participants) {
        if(expenseType.equals(ExpenseType.EQUAL)) {
            return equal(amount, participants);
        }else if(expenseType.equals(ExpenseType.UNEQUAL)) {
            return unEqual(amount, participants);
        }
        return percentage(amount, participants);
    }


    private boolean equal(double amount, List<Split> participants) {
        // logic to validate equal
         return false;
    }
    private boolean unEqual(double amount, List<Split> participants) {
        // logic to validate unequal
         return false;
    }
    private boolean percentage(double amount, List<Split> participants) {
        // logic to validate percentage
         return false;
    }
}
