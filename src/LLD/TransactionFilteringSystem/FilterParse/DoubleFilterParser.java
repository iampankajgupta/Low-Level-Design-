package LLD.TransactionFilteringSystem.FilterParse;

public class DoubleFilterParser implements FilterParser<Double>{
    @Override
    public Double parse(String value) {
        return Double.valueOf(value);
    }
}
