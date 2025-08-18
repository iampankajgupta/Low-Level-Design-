package LLD.SplitwisePractice;
import java.util.Map;
public class PercentageSplitDetail implements SplitDetail{
    private Map<User, Double> userDoubleMap;

    public PercentageSplitDetail(Map<User, Double> userDoubleMap) {
        this.userDoubleMap = userDoubleMap;
    }

    public Map<User, Double> getUserDoubleMap() {
        return userDoubleMap;
    }

    public void setUserDoubleMap(Map<User, Double> userDoubleMap) {
        this.userDoubleMap = userDoubleMap;
    }
}
