package org.example;

import java.time.LocalDate;

/**
 * A service that can calculate the completion date of a task, taking into account weekends and public
 holidays.
 */
public class TaskCalculatorService {
    private LocalDate startDate;
    private int numWorkingDays;

    /**
     * Constructs a new Task with the start date and number of working days.
     *
     * @param startDate The start date of the task.
     * @param numWorkingDays The number of working days needed to complete the task.
     */
    public TaskCalculatorService(LocalDate startDate, int numWorkingDays) {
        this.startDate = startDate;
        this.numWorkingDays = numWorkingDays;
    }

    /**
     * Gets the start date of the task.
     *
     * @return The start date of the task.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the number of working days needed to complete the task.
     *
     * @return The number of working days.
     */
    public int getNumWorkingDays() {
        return numWorkingDays;
    }
}
