package LLD.SplitWise;

import LLD.SplitWise.ExpFactory.ExpenseValidator;
import LLD.SplitWise.ExpFactory.ExpenseValidatorFactory;

import java.util.List;
import java.util.Optional;

public class ExpenseController{
    List<Expense> expenseList;

    public ExpenseController(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public void addExpense(String description, double amount, User userPaid, List<Split> participants, ExpenseType expenseType) {

        // validate the expense
        // create a en
        ExpenseValidator expenseValidator = ExpenseValidatorFactory.getValidator(expenseType);
        boolean valid = expenseValidator.validate(amount, participants);
        if(valid) {
            Expense expense = new Expense(description, expenseType, amount, userPaid, participants);
            expenseList.add(expense);
            // update the user balance Sheet

        }
    }

    public boolean settleExpenseAmount(String expenseId, double amount, User currentUser) {
        Optional<Expense> OptExpense = expenseList.stream().filter(expense -> expense.getExpenseId().equals(expenseId)).findAny();
        if(OptExpense.isPresent()) {
            // expenseUserId should not be the currentUser
            if(!OptExpense.get().getPaidUser().equals(currentUser)) {
                Optional<Split> currentUserDetails = OptExpense.get().getFriendList().stream().filter(user -> user.getUser().getUserId().equals(currentUser.getUserId())).findAny();
                if(currentUserDetails.isPresent()) {
                    return false;
                    /*
                    if(currentUserDetails.get().getAmount() >= amount) {
                        // update the user balance sheet

                    }else {
                        System.out.println("Settled Amount is greater than Owed Amount for expense with id: "+expenseId);
                    }
                    */

                }
            }
            // settle amount
            // check if settle Amount should not be greater than owe amount


        }
        return false;
    }
}
