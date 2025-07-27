package SplitWise.strategy;

import SplitWise.User;

import java.util.List;

public interface SplitStrategy {
    boolean validate(User paidUser, double amount, List<SplitWise.Split> participants);
}
