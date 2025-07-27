package SplitWise.strategy;

import SplitWise.ExpenseValidator;
import SplitWise.Split;
import SplitWise.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EqualSplitStrategy implements ExpenseValidator {
    /*
    @Override
    public boolean validate(User paidUser, double amount, List<Split> participants) {

        List<User> splits = participants.stream().filter(participant -> participant.getId() != paidUser.getId()).collect(Collectors.toList());
        double amountTobeShared = amount / splits.size();
        Map<Integer, Double> splitMoneyParticipants = new HashMap<>();
        for(User user: splits) {
            splitMoneyParticipants.put(user.getId(), amountTobeShared);
        }
        return splitMoneyParticipants;
    }
    */


    @Override
    public boolean validate(double amount, List<Split> participants) {
        return false;
    }
}
