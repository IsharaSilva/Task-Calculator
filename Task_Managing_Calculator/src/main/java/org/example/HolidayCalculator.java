package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for calculating holidays.
 */
public class HolidayCalculator {
    private final List<LocalDate> publicHolidays;

    /**
     * Constructs a new HolidayCalculator object.
     */
    public HolidayCalculator(int year) {
        publicHolidays = new ArrayList<>();
        publicHolidays.add(LocalDate.of(year, 1, 1));
        publicHolidays.add(LocalDate.of(year, 2, 4));
        publicHolidays.add(LocalDate.of(year, 5, 1));
        publicHolidays.add(LocalDate.of(year, 5, 15));
        publicHolidays.add(getPoyaDay(year, 1));
        publicHolidays.add(getPoyaDay(year, 2));
        publicHolidays.add(getPoyaDay(year, 3));
        publicHolidays.add(getPoyaDay(year, 4));
        publicHolidays.add(getPoyaDay(year, 5));
        publicHolidays.add(getPoyaDay(year, 6));
        publicHolidays.add(getPoyaDay(year, 7));
        publicHolidays.add(getPoyaDay(year, 8));
        publicHolidays.add(getPoyaDay(year, 9));
        publicHolidays.add(getPoyaDay(year, 10));
        publicHolidays.add(getPoyaDay(year, 11));
        publicHolidays.add(getPoyaDay(year, 12));
    }

    /**
     * Checks if a given date is a holiday.
     *
     * @param date the date to be checked
     * @return true if the date is a holiday, false otherwise
     */
    public boolean isHoliday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        }
        return publicHolidays.contains(date);
    }

    private LocalDate getPoyaDay(int year, int month) {
        LocalDate monthFirstDay = LocalDate.of(year, month, 1);
        LocalDate monthLastDay = monthFirstDay.withDayOfMonth(monthFirstDay.lengthOfMonth());
        return monthLastDay.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }
}