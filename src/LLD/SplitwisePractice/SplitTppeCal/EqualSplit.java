package LLD.SplitwisePractice.SplitTppeCal;
import LLD.SplitwisePractice.*;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit implements SplitInterface {
    public boolean validate(User paidUser, List<Split> userList, Double amount) {
        return null != paidUser && null != userList && !userList.isEmpty() && amount >= 0;
    }

    @Override
    public List<Split> splitExpense(SplitRequest splitRequest) {

        User paidUser = splitRequest.getPaidUser();
        EqualSplitDetail equalSplitDetail = (EqualSplitDetail) splitRequest.getSplitDetail();
        List<Split> userSplitList = equalSplitDetail.getUserSplitList();
        Double amount = splitRequest.getAmount();
        boolean isValid = validate(paidUser, equalSplitDetail.getUserSplitList(), amount);
        List<Split> splits = new ArrayList<>();
        if(isValid) {
            double splitAmount = (amount / userSplitList.size());
            for(Split split : userSplitList) {
                splits.add(new Split(split.getUser(), splitAmount));
            }
        }
        return splits;
    }
}
