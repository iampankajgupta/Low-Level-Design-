package LLD.SplitwisePractice;
import java.util.List;
public class EqualSplitDetail implements SplitDetail{
    private List<Split> userSplitList;

    public EqualSplitDetail(List<Split> userSplitList) {
        this.userSplitList = userSplitList;
    }

    public List<Split> getUserSplitList() {
        return userSplitList;
    }

    public void setUserSplitList(List<Split> userSplitList) {
        this.userSplitList = userSplitList;
    }
}
