package AdvancedJava;

import java.time.LocalDate;

public class DateAndTimeAPI {

    public static void main(String[] args) {
        System.out.println(LocalDate.now()); // use System Clock
        LocalDate customDate = LocalDate.of(2006,1,5);
        System.out.println(customDate);
        System.out.println(customDate.getDayOfWeek());
    }

//    1. LocalDate
//    A date (Year, Month, Day) with absolutely no time and no time zone context.
//    Best use case: Birthdays, anniversaries, or national holidays (e.g., Christmas is always December 25th, regardless of where you live).
//    Example: 2026-06-06

//    2. LocalTime
//    A time (Hours, Minutes, Seconds, Nanoseconds) without a date or a time zone.
//    Best use case: Opening hours of a local store, or a daily alarm clock.
//    Example: 14:30:00

//    3. LocalDateTime
//    A combination of date and time (Year, Month, Day, Hour, Minute, Second) but still lacking any time zone context.
//    Best use case: Timetables for public transit or scheduling a meeting at a local corporate office.
//    Example: 2026-06-06T14:30:00

//    4. ZonedDateTime
//    A complete date and time representation bundled with a specific time zone (e.g., America/New_York or Asia/Kolkata).
//    It automatically handles daylight saving time (DST) shifts.
//    Best use case: Flight departure/arrival times or scheduling international conference calls.
//    Example: 2026-06-06T14:30:00+05:30[Asia/Kolkata]

//    5. Instant
//    A single specific point on the global timeline, measured as nanoseconds from the Unix Epoch (January 1, 1970 UTC).
//    It is always in UTC.
//    Best use case: Logging server events, database timestamps, and measuring code execution time.
//    Example: 2026-06-05T20:44:48Z

//    6. Duration
//    A time-based amount of time, measured strictly in seconds and nanoseconds.
//    Best use case: Finding the difference between two Instant or LocalTime objects (e.g., measuring a job execution time or a countdown timer).
//    Example: "5 hours, 30 minutes, and 20 seconds"

//    7. Period
//    A date-based amount of time, measured in Years, Months, and Days.
//    Best use case: Finding the difference between two LocalDate objects (e.g., calculating a person's exact age or checking a project deadline).
//    Example: "2 years, 3 months, and 10 days"

//    8. DateTimeFormatter
//    A thread-safe utility class used to convert date-time objects into readable strings (formatting) and vice versa (parsing strings into objects).
//    Best use case: Changing a date like 2026-06-06 into a user-friendly format like 06/06/2026.

//    Quick Cheat Sheet: Duration vs. Period
//    Use Duration for machine time, stopwatch measurements, and precise time gaps (Seconds/Nanos).
//    Use Period for human time, calendar differences, and long-term planning (Years/Months/Days).
}
