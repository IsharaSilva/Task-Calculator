package org.example;

import java.time.LocalDate;

/**
 * A class to calculate completion dates.
 */
public class TaskCalculatorServiceImpl {
    private HolidayCalculator holidayCalculator;

    /**
     * Constructs a new TaskCalculatorService object.
     * @param holidayCalculator the HolidayCalculator to be used for detecting holidays.
     */
    public TaskCalculatorServiceImpl(HolidayCalculator holidayCalculator) {
        this.holidayCalculator = holidayCalculator;
    }

    /**
     * Calculates the completion date of a task.
     * @param startDate the start date of the task
     * @param numOfWorkingDays the number of working days required to complete the task
     * @return the completion date of the task
     */
    public LocalDate getCompletionDate(LocalDate startDate, int numOfWorkingDays) {
        LocalDate completionDate = startDate;
        int workingDaysRemaining = numOfWorkingDays;

        if (!isWorkingDay(startDate)) {
            completionDate = getNextWorkingDay(startDate);
        }

        while (workingDaysRemaining > 0) {
            completionDate = completionDate.plusDays(1);
            if (isWorkingDay(completionDate)) {
                workingDaysRemaining--;
            }
        }
        return completionDate;
    }

    private boolean isWorkingDay(LocalDate date) {
        return date.getDayOfWeek().getValue() < 6 && !holidayCalculator.isHoliday(date);
    }

    private LocalDate getNextWorkingDay(LocalDate date) {
        LocalDate nextWorkingDay = date.plusDays(1);
        while (!isWorkingDay(nextWorkingDay)) {
            nextWorkingDay = nextWorkingDay.plusDays(1);
        }
        return nextWorkingDay;
    }
}