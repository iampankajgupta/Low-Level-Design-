package SplitWise.service;

import SplitWise.BalanceSheet;
import SplitWise.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetService {

    public static void updateParticipantBalance(User paidBy, Map<Integer, Double> splitMap, List<User> finalParticipants) {

        // participants looks unncessary so lets remove and create a UserService which returns us the getUserById;


        /*
        for (User user : finalParticipants) {
            BalanceSheet balanceSheet = user.getBalanceSheet();
            if (balanceSheet.getOwe().containsKey(paidBy.getId())) {
                double totalOwe = balanceSheet.getOwe().get(paidBy.getId()) + splitMap.get(user.getId());
                balanceSheet.getOwe().put(paidBy.getId(), totalOwe);
                paidBy.getBalanceSheet().getTake().put(user.getId(), totalOwe);
            } else {
                balanceSheet.getOwe().put(paidBy.getId(), splitMap.get(user.getId()));
                paidBy.getBalanceSheet().getTake().put(user.getId(), splitMap.get(user.getId()));
            }
        }


         */
    }
}
