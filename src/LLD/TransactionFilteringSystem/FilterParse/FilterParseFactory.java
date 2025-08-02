package LLD.TransactionFilteringSystem.FilterParse;

public class FilterParseFactory {

    public static FilterParser<?> getFilterParse(Class<?> classType) {
        if(classType == Integer.class) {
            return new IntegerFilterParser();
        }else if(classType == Double.class) {
            return new DoubleFilterParser();
        }else if(classType == Long.class) {
            return new LongFilterParser();
        }
        // custom type
        else {
           return new StringFilterParser();
        }
    }
}
