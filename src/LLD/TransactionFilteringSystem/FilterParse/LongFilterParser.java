package LLD.TransactionFilteringSystem.FilterParse;

public class LongFilterParser implements FilterParser<Long> {
    @Override
    public Long parse(String value) {
        return Long.valueOf(value);
    }
}
