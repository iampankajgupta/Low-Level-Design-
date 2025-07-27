package SplitWise.service;

import SplitWise.Balance;
import SplitWise.BalanceSheet;
import SplitWise.User;

import java.util.List;
import java.util.Map;

public class UserService {

    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void updateBalanceSheet(User paidUser, List<SplitWise.Split> participants) {

        for(User user:  userList) {

            if(user.getId() == paidUser.getId()) {

                // loop over the participants
                BalanceSheet balanceSheet = paidUser.getBalanceSheet();
                Map<Integer, Balance> userBalance = balanceSheet.getUserBalance();
                for(SplitWise.Split oweUser : participants) {
                    int oweUserId = oweUser.getUser().getId();
                    if(oweUser.getUser().getId() != paidUser.getId()) {
                        if(userBalance.containsKey(oweUserId)) {
                            Balance balance = userBalance.get(oweUserId);
                            balance.setOwe(balance.getOwe() + oweUser.getAmount());
                            userBalance.put(oweUserId, balance);
                        }else {
                            Balance balance = new Balance(oweUser.getAmount(), 0);
                            userBalance.put(oweUserId, balance);
                        }
                    }
                    // this i have added if percemtage split has been use then add only that amount only
                    // if there was only Equal based and might have calculated ( mapSize -1 ) * amount
                    balanceSheet.setTotalSpent(balanceSheet.getTotalSpent() + oweUser.getAmount());
                    balanceSheet.setTotalGet(balanceSheet.getTotalGet() + oweUser.getAmount());

                }
                balanceSheet.setUserBalance(userBalance);
                user.setBalanceSheet(balanceSheet);
            }

        }

    }
}
