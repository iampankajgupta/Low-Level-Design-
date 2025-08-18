package LLD.SplitwisePractice.SplitTppeCal;

import LLD.SplitwisePractice.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentageSplit implements SplitInterface {
   /*
    public List<Split> getSplit(User paidUser, Map<User, Double> percentageMap, Double amount) {
        boolean validate = validate(paidUser, percentageMap, amount);
        List<Split> splitList = new ArrayList<>();
        if(validate) {
            for(Map.Entry<User, Double> entry : percentageMap.entrySet()) {
                User user = entry.getKey();
                Double value = entry.getValue();
                Split split = new Split(user, value != 0 ? (value / 100)* amount: 0);
                splitList.add(split);
            }
        }
        return splitList;

    }
    */


    public boolean validate(User paidUser, Map<User, Double> percentageMap, Double amount) throws IllegalArgumentException {
        // Validate fields
        if(null == paidUser) {
            throwException("paidUser");
        }
        if(percentageMap.isEmpty()) {
          throwException("SplitMap");
        }
        if(amount <=0) {
            throwException(amount);
        }
        // check if the combine percentages comes out as 100%
        double totalPercentage = 0;
        for(Double value : percentageMap.values()) {
            totalPercentage += value;
        }

        if(totalPercentage!= 100) {
            throwException(totalPercentage);
        }

        return true;
    }


    public <T> boolean throwException(T field) {
        throw new IllegalArgumentException(field.toString() + "Does not have a valid value");
    }

    @Override
    public List<Split> splitExpense(SplitRequest splitRequest) {
        PercentageSplitDetail splitDetail = (PercentageSplitDetail) splitRequest.getSplitDetail();
        Map<User, Double> percentageMap = splitDetail.getUserDoubleMap();
        User paidUser = splitRequest.getPaidUser();
        Double amount = splitRequest.getAmount();
        boolean validate = validate(paidUser, percentageMap, splitRequest.getAmount());
        List<Split> splitList = new ArrayList<>();
        if(validate) {
            for(Map.Entry<User, Double> entry : percentageMap.entrySet()) {
                User user = entry.getKey();
                Double value = entry.getValue();
                Split split = new Split(user, value != 0 ? (value / 100)* amount: 0);
                splitList.add(split);
            }
        }
        return splitList;
    }
}
