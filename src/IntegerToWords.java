//import java.util.HashMap;
//import java.util.Map;
//
//public class IntegerToWords {
//    static Map<Integer, String> units = new HashMap<>();
//    static Map<Integer, String> tens = new HashMap<>();
//    static Map<Integer, String> hundred = new HashMap<>();
//    static Map<Integer, String> placeDigitMap = new HashMap<>();
//
//
//    public static void main(String[] args) {
//        fillUpUnitsMap(units);
//        fillUpUnitsMap(tens);
//        fillUpUnitsMap(hundred);
//        fillUppPlaceDigitMap(placeDigitMap);
//        int number = 10;
//        if (number < 10) {
//            System.out.println(units.get(number));
//        }
//        if (number > 10 && number < 20) {
//            System.out.println(tens.get(number));
//        }
//
//        int count = 0;
//        int divisor = 0
//        if (number < 100) {
//            divisor= 10;
//            count = 2;
//        }
//        else if (number < 1000) {
//            divisor= 100;
//            count = 3;
//        }
//        else if (number < 10000) {
//            divisor= 1000;
//            count = 4;
//        }
//
//
//    }
//
//
//    public static String integerTowWords(int nums, int count, int divisor) {
//        if (nums <= 0) return "";
//        int remainder = nums / divisor;
//        int quotient = nums % divisor;
//        nums = nums / divisor;
//        divisor = divisor / 10;
//        if(placeDigitMap.get(count))
//
//
//            // if du
//
//
//    }
//
//    private static void fillUppPlaceDigitMap(Map<Integer, String> placeDigitMap) {
//        placeDigitMap.put(3, "hundred");
//        placeDigitMap.put(4, "thousand");
//
//    }
//
//    private static void fillUpUnitsMap(Map<Integer, String> units) {
//        units.put(1, "one");
//        units.put(2, "two");
//        units.put(3, "three");
//        units.put(4, "four");
//        units.put(5, "five");
//        units.put(6, "six");
//        units.put(7, "seven");
//        units.put(7, "eight");
//        units.put(8, "nine");
//    }
//
//    private static void fillUpTensMap(Map<Integer, String> tens) {
//        tens.put(10, "ten");
//        tens.put(11, "eleven");
//        tens.put(12, "twelve");
//        tens.put(13, "thirteen");
//        tens.put(14, "fourteen");
//        tens.put(15, "fifteen");
//        tens.put(16, "sixteen");
//        tens.put(17, "seventeen");
//        tens.put(18, "eighteen");
//        tens.put(19, "nineteen");
//    }
//
//    private static void fillUpHunderedsMap(Map<Integer, String> hundred) {
//        units.put(10, "ten");
//        units.put(20, "twenty");
//        units.put(30, "thirty");
//        units.put(40, "fourty");
//        units.put(50, "fifty");
//        units.put(60, "sixty");
//        units.put(70, "seventy");
//        units.put(80, "eighty");
//        units.put(90, "ninety");
//    }
//}
