package SplitWise;

import SplitWise.factory.SplitFactory;
import SplitWise.service.BalanceSheetService;
import SplitWise.service.GroupService;

import java.util.List;
import java.util.Map;

public class ExpenseService {
    private List<Expense> expenses;

    public ExpenseService(GroupService groupService, List<Expense> expenses) {
        this.expenses = expenses;
        this.groupService = groupService;

    }
    private GroupService groupService;

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }


    public Expense createExpense(int groupId, User paidUser, String description, double amount, List<SplitWise.Split> participants, SplitType splitType) throws IllegalAccessException {
        boolean isValid = SplitFactory.getSplitStrategy(splitType).validate(paidUser, amount, participants);
        if(isValid) {
            Expense expenseInGroup = groupService.createExpenseInGroup(groupId, paidUser, description, amount, participants, splitType);
            expenses.add(expenseInGroup);
            return expenseInGroup;
        }
        return null;
    }


    void addExpense(Expense expense) {
        // add in expenseList
        // update the users balanceSheet
        expenses.add(expense);
        User paidUser = expense.getPaidUser();
        //int amount  = expense.getAmount();
        //List<User> participants = expense.getParticipants();
//        A split() method shouldn't return a single value, because splitting means calculating how much each
//        double amountTobeDistributed =  SplitFactory.getSplitStrategy(expense.getSplitType()).split(paidUser,amount, participants);
       // Map<Integer, Double> splitMap = SplitFactory.getSplitStrategy(expense.getSplitType()).validate(paidUser, amount, participants);
        //BalanceSheetService.updateParticipantBalance(paidUser, splitMap, participants);
    }

    public void settleExpense(User user, int amount, int expenseId) {
        Expense expenseTobe = expenses.stream().filter(expense -> expense.getId() == expenseId).findFirst().get();
        // check if th user exists in the participants
        // if yes , deduct the owe amount from the user and update owe map also  update the paidNy user take map
    }
}
