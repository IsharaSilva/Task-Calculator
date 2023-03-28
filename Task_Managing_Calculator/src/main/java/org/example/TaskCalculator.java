package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main class for getting user inputs and calculate the task completion date.
 */
public class TaskCalculator {
    public static void main(String[] args) {

        int year = getUserInputInt("Enter the year: ");
        HolidayCalculator holidayCalculator = new HolidayCalculator(year);

        LocalDate startDate = getUserInputDate();
        int numOfWorkingDays = getUserInputInt("Enter number of working days: ");

        TaskCalculatorServiceImpl taskCalculator = new TaskCalculatorServiceImpl(holidayCalculator);

        LocalDate completionDate = taskCalculator.getCompletionDate(startDate, numOfWorkingDays);
        System.out.println("Task completion date: " + completionDate);
    }

    private static int getUserInputInt(String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(input);
        int userInput = 0;
        while (true) {
            try {
                userInput = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Invalid input. Please enter an integer.");
                System.out.print(input);
            }
        }
        return userInput;
    }

    private static LocalDate getUserInputDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter task start date (YYYY-MM-DD): ");
        LocalDate dateInput = null;
        while (true) {
            try {
                dateInput = LocalDate.parse(scanner.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a date in the format YYYY-MM-DD.");
            }
        }
        return dateInput;
    }
}