package LLD.TransactionFilteringSystem.FilterParse;

public interface FilterParser<T> {
    T parse(String value);
}
