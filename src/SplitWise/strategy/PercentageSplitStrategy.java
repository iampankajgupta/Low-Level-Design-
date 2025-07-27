package SplitWise.strategy;

import SplitWise.Split;
import SplitWise.User;

import java.util.List;

public class PercentageSplitStrategy implements SplitStrategy{
    @Override
    public boolean validate(User paidUser, double amount, List<Split> participants) {
        return false;
    }
}
