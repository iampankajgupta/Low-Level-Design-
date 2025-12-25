package LLD.SplitwisePractice;

import SplitWise.Balance;
import SplitWise.BalanceSheet;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService implements IExpenseService{
    private List<Expense> expenseList = new ArrayList<>();



    @Override
    public void addExpense(SplitRequest splitRequest) {
        SplitInterface splitType = SplitTypeFactory.getSplitType(splitRequest.getSplitType());
        List<Split> splits = splitType.splitExpense(splitRequest);
        // Update balanceSheet of Users

        for(Split split : splits) {
            if(split.getUser().equals(splitRequest.getPaidUser())) {
                BalanceSheet balanceSheet = splitRequest.getPaidUser().getBalanceSheet();
                balanceSheet.setTotalSpent(balanceSheet.getTotalSpent() + splitRequest.getAmount());
                balanceSheet.setTotalGet(balanceSheet.getTotalGet() + split.getAmount()* splits.size() - 1);
                // update the balances
                if(balanceSheet.getUserBalance().containsKey(split.getUser().getId())) {
                    Double existingAmount = balanceSheet.getUserBalance().get(split.getUser().getId());
                    balanceSheet.getUserBalance().put(split.getUser().getId(), existingAmount + split.getAmount());
                }
                split.getUser().setBalanceSheet(balanceSheet);

            }else {
                // increment
                // total owe
                // update the map
                BalanceSheet balanceSheet1 = split.getUser().getBalanceSheet();
                // updated the total owe

                Double amount = balanceSheet1.getUserBalance().containsKey(splitRequest.getPaidUser().getId()) ?
                        balanceSheet1.getUserBalance().get(splitRequest.getPaidUser()) + split.getAmount() : split.getAmount();
                balanceSheet1.setTotalOwe(balanceSheet1.getTotalOwe() + split.getAmount());
                balanceSheet1.getUserBalance().put(split.getUser().getId(), amount);
            }
        }



    }

    @Override
    public void updateExpense(SplitRequest splitRequest) {
        // Only the user created the expense can update the expense
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }
}
