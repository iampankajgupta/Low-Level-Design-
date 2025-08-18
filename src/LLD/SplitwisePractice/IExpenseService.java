package LLD.SplitwisePractice;

import java.util.List;
import SplitWise.SplitType;

public interface IExpenseService {

    void addExpense(SplitRequest splitRequest);
    void updateExpense(SplitRequest splitRequest);
}
