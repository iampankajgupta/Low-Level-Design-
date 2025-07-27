package LLD.SplitWise;

import java.util.List;
import java.util.Map;


public class BalanceSheetController {

/*
    public void updateUserBalanceSheet(User paidUser, List<Split> splitList, double amount, boolean isSettle) {
        UserExpenseBalanceSheet paidUserBalanceSheet = paidUser.getBalanceSheet();
        double totalPayment = isSettle ? paidUserBalanceSheet.getTotalPayment() - amount : paidUserBalanceSheet.getTotalPayment() + amount;
        paidUserBalanceSheet.setTotalPayment(totalPayment);
        for (Split split : splitList) {
            UserExpenseBalanceSheet splitUserBalanceSheet = split.getUser().getBalanceSheet();
            if (split.getUser().getUserId().equals(paidUser.getUserId())) {
                paidUserBalanceSheet.setTotalYourExpense(paidUserBalanceSheet.getTotalYourExpense() + split.getAmount());
            } else {
                // total getBack
                paidUserBalanceSheet.setTotalYourGetBack(paidUserBalanceSheet.getTotalYourGetBack() + split.getAmount());
                Balance userOweBalance;

                // uska pehle bhi bacha hua hai
                if (paidUserBalanceSheet.getBalanceSheet().containsKey(split.getUser().getUserId())) {
                    paidUserBalanceSheet.getBalanceSheet().get(split.getUser().getUserId()).setOwe(paidUserBalanceSheet.getBalanceSheet().get(split.getUser().getUserId()).getOwe() + split.getAmount());
                } else {
                    userOweBalance = new Balance();
                    userOweBalance.setTake(split.getAmount());
                    paidUserBalanceSheet.getBalanceSheet().put(split.getUser().getUserId(), userOweBalance);
                }

                // update the balance sheet of owe user

                split.getUser().getBalanceSheet().setTotalOwe(split.getUser().getBalanceSheet().getTotalOwe() + split.getAmount());
                split.getUser().getBalanceSheet().setTotalYourExpense(split.getUser().getBalanceSheet().getTotalYourExpense() + split.getAmount());

                Balance userPaidBalance;
                if (splitUserBalanceSheet.getBalanceSheet().containsKey(paidUser.getUserId())) {
                    splitUserBalanceSheet.getBalanceSheet().get(paidUser.getUserId()).setOwe(split.getAmount());
                } else {
                    userPaidBalance = new Balance();
                    userPaidBalance.setOwe(split.getAmount());
                    splitUserBalanceSheet.getBalanceSheet().put(paidUser.getUserId(), userPaidBalance);
                }
            }

        }

    }

//    public Map<String, Double> getUserBalanceSheet(User currentUser) {
////        return UserExpenseBalanceSheet.getBalanceSheet().get(currentUser.getUserId());
//    }

    public Balance getTotalUserBalance(User user) {
        double totalOwe = 0;
        double totalGet = 0;

//        Map<String, Double> userBalanceSheet = getUserBalanceSheet(user);
//        for (Double owe : userBalanceSheet.values()) {
//            totalGet += owe;
//        }

        // Check in rest of map if current User has owe anything
//        for (Map.Entry<String, Map<String, Double>> mapEntry : UserExpenseBalanceSheet.getBalanceSheet().entrySet()) {
//            if (!mapEntry.getKey().equals(user.getUserId())) {
//                if (mapEntry.getValue().containsKey(user.getUserId())) {
//                    totalOwe += mapEntry.getValue().get(user.getUserId());
//                }
//            }
//        }
//        return new Balance(totalOwe, totalGet);

        return new Balance();

    }

 */
}
