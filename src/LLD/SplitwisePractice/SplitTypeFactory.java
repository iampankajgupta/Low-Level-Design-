package LLD.SplitwisePractice;

import LLD.SplitwisePractice.SplitTppeCal.EqualSplit;
import LLD.SplitwisePractice.SplitTppeCal.PercentageSplit;
import SplitWise.SplitType;

public class SplitTypeFactory {
    public static SplitInterface getSplitType(SplitType splitType) {
        if(splitType.equals(SplitType.EQUALLY)) {
            return new EqualSplit();
        }else if(splitType.equals(SplitType.PERCENTAGE_BASED)) {
            return new PercentageSplit();
        }
        else {
            throw new IllegalArgumentException("Illegal State Exception");
        }
    }
}
