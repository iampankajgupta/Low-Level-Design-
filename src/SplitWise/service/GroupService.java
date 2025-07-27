package SplitWise.service;

import SplitWise.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GroupService {
    private List<Group> groupList;
    private ExpenseService expenseService;
    private UserService userService;

    public GroupService(List<Group> groupList, ExpenseService expenseService, UserService userService) {
        this.groupList = groupList;
        this.expenseService = expenseService;
        this.userService = userService;
    }

    public Group createGroup(String name, String description, List<User> userList, List<Expense> expenseList, boolean isAllBalanceSettled) {
        int index = groupList.isEmpty() ? 1 : groupList.size() + 1;
        Group group = new Group(index, name, description, userList, expenseList, isAllBalanceSettled);
        groupList.add(group);
        return group;
    }

    public Group updateGroup(Group group) {
        //
        return null;
    }

    public Expense createExpenseInGroup(int groupId,User paidUser, String description,  double amount, List<SplitWise.Split> participants, SplitType splitType) throws IllegalAccessException {

        // Assuming that amount is already being
        // update expense in the group
        for (Group group : groupList) {
            if (group.getGroupId() == groupId) {
                Expense expense = expenseService.createExpense(groupId, paidUser, description, amount, participants, splitType);
                group.getExpenseList().add(expense);
                // update the expense of the group
                Map<Integer, List<UserBalancePair>> oweBalanceSheet = group.getOweBalanceSheet();
                Map<Integer, List<UserBalancePair>> takeBalanceSheet = group.getTakeBalanceSheet();

                for(SplitWise.Split split : participants) {
                    if(split.getUser().getId() != paidUser.getId()) {
                        User splitUser = split.getUser();
                        double splitUserOweAmount = split.getAmount();
                        if(oweBalanceSheet.containsKey(splitUser.getId())) {
                            List<UserBalancePair> oweUserBalancePairs = oweBalanceSheet.get(splitUser.getId());
                            List<UserBalancePair> takeUserBalancePair = takeBalanceSheet.get(paidUser.getId());
                            boolean oweUserFound = false;
                            boolean takeUserFound = false;

                            // check in the take userBalancePair ki pehle split User ko paid user ko dena toh nhi tha
                            for(UserBalancePair userBalancePair: oweUserBalancePairs) {

                                if(userBalancePair.getUser().getId() == paidUser.getId()) {
                                    // agr already dena tha then just add the amount
                                    oweUserFound = true;
                                    userBalancePair.setAmount(userBalancePair.getAmount() + splitUserOweAmount);
                                }
                            }
                            if(!oweUserFound) {
                                // agr dena mhi tha pehle then just create a new amount
                                oweUserBalancePairs.add(new UserBalancePair(splitUserOweAmount, paidUser));
                                group.getOweBalanceSheet().put(splitUser.getId(), oweUserBalancePairs);
                            }

                            // check in the take userBalancePair ki pehle paid User ko usse lena toh nhi tha
                            for(UserBalancePair userBalancePair: takeUserBalancePair) {
                                if(userBalancePair.getUser().getId() == splitUser.getId()) {
                                    // agr already lena tha then just add the amount
                                    takeUserFound = true;
                                    userBalancePair.setAmount(userBalancePair.getAmount() + splitUserOweAmount);
                                }
                            }
                            if(!takeUserFound) {
                                takeUserBalancePair.add(new UserBalancePair(paidUser.getId(), splitUser));
                                group.getTakeBalanceSheet().put(splitUser.getId(), takeUserBalancePair);
                            }
                        }else {
                            List<UserBalancePair> userBalancePair = new ArrayList<>();
                            userBalancePair.add(new UserBalancePair(splitUserOweAmount, paidUser));
                            oweBalanceSheet.put(splitUser.getId(), userBalancePair);

                            List<UserBalancePair> takeUserBalancePair = new ArrayList<>();
                            takeUserBalancePair.add(new UserBalancePair(splitUserOweAmount, splitUser));
                            takeBalanceSheet.put(paidUser.getId(), takeUserBalancePair);
                        }

                        // update expense of user
                        userService.updateBalanceSheet(paidUser, participants);
                    }
                }

                return expense;
            }
        }
        throw new IllegalAccessException("Group Id: " + groupId + " does not found");
    }

    public void settleExpenseInGroup(int groupId, User user ,User paidUser, double amount) throws IllegalAccessException {
        for (Group group : groupList) {
            if (group.getGroupId() == groupId) {
                Map<Integer, List<UserBalancePair>> oweBalanceSheet = group.getOweBalanceSheet();
                Map<Integer, List<UserBalancePair>> takeBalanceSheet = group.getTakeBalanceSheet();

                // get the user to whom he has owe list
                List<UserBalancePair> oweUserBalancePairs = oweBalanceSheet.get(user.getId());
                boolean oweUserFound = false;
                boolean takeUserFound = false;
                for(UserBalancePair userBalancePair :  oweUserBalancePairs) {
                    if(userBalancePair.getUser().getId() == paidUser.getId()) {
                        oweUserFound = true;
                        // check if the amount is less than or equal to amount to be paid
                        // else ?????

                    }
                }

                if(!oweUserFound) {
                    throw new IllegalAccessException("User with id"+user.getId()+" does not owe to : "+paidUser.getId());
                }
            }
        }

    }
    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public ExpenseService getExpenseService() {
        return expenseService;
    }

    public void setExpenseService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public Optional<Group> getGroupById(int groupId) {
        return groupList.stream().filter(group -> group.getGroupId() == groupId).findAny();
    }
}
