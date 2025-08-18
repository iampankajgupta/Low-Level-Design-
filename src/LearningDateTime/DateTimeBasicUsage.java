package LearningDateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DateTimeBasicUsage {
    public static void main(String[] args) {
        // All these are thread safe
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2025,04,03);
        System.out.println("Today's Date is"+localDate);

        // LocalTime

        LocalTime localTime = LocalTime.now();
        System.out.println("Local time is: "+localTime);

        LocalTime localTime1 = LocalTime.of(14,33,40);
        System.out.println(localTime1);

        // LocalDateTime  Date + Time (no timezone)
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local Date Time is: "+localDateTime);
        // To define specific local Date time

        LocalDateTime localDateTime1 = LocalDateTime.of(2025,04,3,18,2,6);

        /*
        🧠 Use-cases:
            Transaction timestamp (if timezone isn’t required)
            Booking time
         */

        // Date + Time with timezone
        //🧠 Use-cases:
        //Global applications (e.g., meeting timezones, travel bookings)
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current ZoneDate time is: "+zonedDateTime);
        ZonedDateTime utc = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("UTC ZoneDate Time is:"+ utc);

        // Instant ->
        Instant instant = Instant.now(); // Always in UTC
        System.out.println("Instant time is: "+instant);



        // Operations on Time

        LocalDate localDate2 = LocalDate.now();
        LocalDate localDate3 = localDate2.plusDays(10);

        LocalDateTime localDateTime2 = LocalDateTime.now();
        LocalDateTime localDateTime3 = localDateTime2.plusDays(10);
        LocalDateTime localDateTime4 = localDateTime2.minusHours(2); // Subtracting hours
        LocalDateTime localDateTime5 = localDateTime2.minusMinutes(50); // Subtracting minutes


        // Comparsion
        LocalDate localDate4 = LocalDate.now();
        LocalDate localDate5 = localDate4.minusDays(10);

        System.out.println("LocalDate is After another localDate");
        System.out.println(localDate4.isAfter(localDate5));
        System.out.println("LocalDate is Before another localDate");
        System.out.println(localDate4.isBefore(localDate5));


        // ✅ 3. Parsing and Formatting with DateTimeFormatter

        String dateStr = "2025-08-15T10:30";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateStr);
        System.out.println("Parsed Date Time is: "+parsedDateTime);


        // With Custom Format

        String customDateTime = "2025-08-15 10:30";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime localDateTime6 = LocalDateTime.parse(customDateTime, dateTimeFormatter);
        System.out.println("Custom LocalDateTime parse");

        // Format to String
        String formatted = parsedDateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm"));
        System.out.println("Formatted String is: "+formatted);

        // 🔸 Example: Filter transactions between 2025-08-01 and 2025-08-03

        List<Transaction> transactions = new ArrayList<>();

        LocalDateTime start = LocalDateTime.parse("2025-08-01T00:00");
        LocalDateTime end = LocalDateTime.parse("2025-08-03T23:59");

        // filter LocalDateTime between start and end;
        List<Transaction> collect = transactions.stream().filter(transaction -> ((transaction.getLocalDateTime().isAfter(start) || transaction.getLocalDateTime().isEqual(start)) &&
                transaction.getLocalDateTime().isBefore(end) || transaction.getLocalDateTime().equals(end))).collect(Collectors.toList());


        // Instant Version --> Always in UTC
        Instant startInstant = Instant.parse("2025-08-01T00:00:00Z");
        Instant endInstant = Instant.parse("2025-08-03T23:59:59Z");

        List<Transaction> collect1 = transactions.stream().filter(transaction ->
                transaction.getInstant().isAfter(startInstant) &&
                        transaction.getInstant().isBefore(endInstant)).collect(Collectors.toList());



        // Sorting by Date/Time
        // When you sort LocalDateTime, both the date and time are considered together, in natural chronological order.
        ///  compares in this exact order:
        ///  Year Month Day Hour Minute Second  Nanosecond -> In this way comparing  is being done -> first check for year then month etc

        /*
        ✅ Example:
            Assume 3 transactions:
            T1: 2025-08-01T09:00
            T2: 2025-08-01T15:30
            T3: 2025-07-31T18:45
            If sorted ascending, result will be:

            T3 → T1 → T2
            Explanation:

            T3 has the earliest date (July 31)

            T1 and T2 are both August 1, so then it sorts by time (09:00 before 15:30)
         */

        // Sorting in ascending order
        List<Transaction> collect2 = transactions.stream().sorted(Comparator.comparing(Transaction::getLocalDateTime)).toList();
        // Not allowed
        /// List<Transaction> collect3 = transactions.stream().sorted((a,b) -> a.getLocalDateTime().isBefore(b.getLocalDateTime())).collect(Collectors.toList());

        // Sort in descending order
        List<Transaction> collect3 = transactions.stream().sorted(Comparator.comparing(Transaction::getLocalDateTime).reversed()).toList();


        // If LocalDateTime and you want to sort based on date only

        /*
        * You're almost there! The issue is that you're trying to call .reversed() on the lambda expression directly, which doesn't work, because:

        Comparator.comparing(t -> t.getLocalDateTime().toLocalTime())
        returns a Comparator, but when chained like that, the compiler can’t infer the correct types for .reversed().

        ✅ Fix:
        You need to store the comparator first or provide it in a form the compiler can understand:

        List<Transaction> reverseOrder = transactions.stream()
            .sorted(Comparator.comparing((Transaction t) -> t.getLocalDateTime().toLocalTime()).reversed())
            .toList();

        * */

        /// ascending
        List<Transaction> list = transactions.stream().sorted(Comparator.comparing(t -> t.getLocalDateTime().toLocalDate())).toList();
        /// descending
        List<Transaction> reversedOrder = transactions.stream().sorted(Comparator.comparing((Transaction t) -> t.getLocalDateTime().toLocalDate()).reversed()).toList();

        // if LocalDateTime is used and you want to sort based on the time only
        // ascending
        List<Transaction> list1 = transactions.stream().sorted(Comparator.comparing(t -> t.getLocalDateTime().toLocalTime())).toList();

        // descending
        List<Transaction> reverseOrder = transactions.stream().sorted(Comparator.comparing((Transaction t) -> t.getLocalDateTime().toLocalTime()).reversed()).toList();

        // filtering last 30 days transactions
            LocalDateTime localDate6 = LocalDateTime.now().minusDays(30);
            transactions.stream().filter(transaction -> transaction.getLocalDateTime().isEqual(localDateTime6) ||
                    transaction.getLocalDateTime().isAfter(localDateTime6)).toList();

        // above filtering filtering can be simplified like
        List<Transaction> thirtyDaysBeforeTransaction = transactions.stream().filter(transaction -> !transaction.getLocalDateTime().isBefore(localDate6)).toList();


        //// Exmaple of Movie Booking System
        /*
        * Booking
        * private bookingTimeStamp Instant ->
        * private movieStartTime ZoneDateTime -> since if the app is at global level then it should be ZoneDateTime format as in the history
        * if users see then based on his timezone he should see
        *
        * private bookingTimeStamp ZoneDateTime -> I was thinking to include but this can be derived from bookingTimeStamp(Instant)
        *
        * How ?
        *
        * From LocalDateTime
        * ZonedDateTime bookingDateTime = transactions.get(0).getLocalDateTime().atZone(ZoneId.of("Asia/Kolkata"));
        *
        * From Instant
        * ZoneDateTime zone = transactions.get(0).getInstant().atZone(ZoneId.of("Asia/Kolkata"));
        *
        * */



    }
}

class Transaction{
    private LocalDateTime localDateTime;
    private Instant instant;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
}
