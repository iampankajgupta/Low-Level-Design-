package LLD.TransactionFilteringSystem.FilterParse;

public class IntegerFilterParser implements FilterParser<Integer>{
    @Override
    public Integer parse(String value) {
        return Integer.valueOf(value);
    }
}
