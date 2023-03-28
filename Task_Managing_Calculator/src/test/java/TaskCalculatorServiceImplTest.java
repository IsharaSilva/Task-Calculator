import org.example.HolidayCalculator;
import org.example.TaskCalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * The class contains unit tests for the TaskCalculatorService class.
 */
public class TaskCalculatorServiceImplTest {

    private final HolidayCalculator holidayCalculator = new HolidayCalculator(2023);
    private final TaskCalculatorServiceImpl taskCalculator = new TaskCalculatorServiceImpl(holidayCalculator);

    /**
     * This test verifies that returns the expected completion date using only working days.
     */
    @Test
    public void testFindCompletionDate_withWorkingDays() {
        LocalDate startDate = LocalDate.of(2023, 3, 21);
        int numWorkingDays = 2;
        LocalDate expectedCompletionDate = LocalDate.of(2023, 3, 23);
        LocalDate actualCompletionDate = taskCalculator.getCompletionDate(startDate, numWorkingDays);
        Assertions.assertEquals(expectedCompletionDate, actualCompletionDate);
    }

    /**
     * This test verifies that returns the expected completion date using working and weekend days.
     */
    @Test
    public void testFindCompletionDate_withNonWorkingDays() {
        LocalDate startDate = LocalDate.of(2023, 3, 21);
        int numWorkingDays = 5;
        LocalDate expectedCompletionDate = LocalDate.of(2023, 3, 29);
        LocalDate actualCompletionDate = taskCalculator.getCompletionDate(startDate, numWorkingDays);
        Assertions.assertEquals(expectedCompletionDate, actualCompletionDate);
    }

    /**
     * This test verifies that returns the expected completion date using holidays and weekends.
     */
    @Test
    public void testFindCompletionDate_withWeekendAndHolidays() {
        LocalDate startDate = LocalDate.of(2023, 4, 27);
        int numWorkingDays = 5;
        LocalDate expectedCompletionDate = LocalDate.of(2023, 5, 5);
        LocalDate actualCompletionDate = taskCalculator.getCompletionDate(startDate, numWorkingDays);
        Assertions.assertEquals(expectedCompletionDate, actualCompletionDate);
    }

    /**
     * This test verifies that returns the expected completion date while start date on weekend.
     */
    @Test
    void testFindCompletionDate_withStartOnWeekend() {
        LocalDate startDate = LocalDate.of(2023, 2, 4);
        int numWorkingDays = 5;
        LocalDate expectedCompletionDate = LocalDate.of(2023, 2, 13);
        LocalDate actualCompletionDate = taskCalculator.getCompletionDate(startDate, numWorkingDays);
        Assertions.assertEquals(expectedCompletionDate, actualCompletionDate);
    }

    /**
     * This test verifies that returns the expected completion date while start date on holiday.
     */
    @Test
    public void testFindCompletionDate_withStartDateOnHoliday() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        int numWorkingDays = 1;
        LocalDate expectedCompletionDate = LocalDate.of(2023, 1, 3);
        LocalDate actualCompletionDate = taskCalculator.getCompletionDate(startDate, numWorkingDays);
        Assertions.assertEquals(expectedCompletionDate, actualCompletionDate);
    }
}