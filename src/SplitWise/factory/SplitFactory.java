package SplitWise.factory;

import SplitWise.SplitType;
import SplitWise.strategy.EqualSplitStrategy;
import SplitWise.strategy.PercentageSplitStrategy;
import SplitWise.strategy.SplitStrategy;

public class SplitFactory {



    public static SplitStrategy getSplitStrategy(SplitWise.SplitType splitType) {
        return null; // for now returning null
        /*
        if(splitType.equals(SplitType.EQUALLY)) {
            return new EqualSplitStrategy();
        }
        else if(splitType.equals(SplitType.PERCENTAGE_BASED)) {
            return new PercentageSplitStrategy();
        }
        return new EqualSplitStrategy();
        */

    }
}
