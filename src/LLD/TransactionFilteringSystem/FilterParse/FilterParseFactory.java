package LLD.TransactionFilteringSystem.FilterParse;

public class FilterParseFactory {

    public static FilterParser<?> getFilterParse(Class<?> classType, String value) {
        if(classType == Integer.class) {
            return new IntegerFilterParser();
        }else if(classType == Double.class) {
            return new DoubleFilterParser();
        }else if(classType == Long.class) {
            return new LongFilterParser();
        }else if(classType == String.class) {
            return new StringFilterParser();
        }
        // custom type
        else {
            throw new IllegalArgumentException();
        }
    }
}
