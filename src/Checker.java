import java.util.InputMismatchException;
import java.util.Scanner;

public class Checker {


    //Validation of input when creating a cinema room. (Enter a non-digit number or a number less than 1).
    public int getSeatsRows(int seats, boolean isChecked, Scanner scanner, Printer printer, String seat) {
        printer.printInConsole(String.format("Enter the number of %s:\n", seat));
        while (isChecked) {
            try {
                seats = scanner.nextInt();
                while (seats < 1) {
                    printer.printInConsole("Wrong input, enter the number bigger than 0\n");
                    seats = scanner.nextInt();
                }
                isChecked = false;

            } catch (InputMismatchException e) {
                printer.printInConsole(String.format("Wrong input, enter the number %s:\n", seat));
                scanner.next();
            }
        }
        return seats;
    }

    //Menu printing and input verification (Enter a non-digit input).
    //Verification of the number other than in the menu checked at the switch-case.
    public int getChoice(int choice, boolean isChecked, Scanner scanner, Printer printer) {
        while (isChecked) {
            try {
                printer.printMenu();
                choice = scanner.nextInt();
                isChecked = false;
            } catch (InputMismatchException e) {
                printer.printInConsole("Wrong input, enter the number from menu.\n");
                scanner.next();
            }
        }
        return choice;
    }

    //getRow and getSeat methods:
    //Checking the input of the selected place of the cinema hall (Entering a number less than 1, entering a number
    //greater than the number of rows/seats, entering a non-digit input)
    public int getRow(int row, boolean isChecked, Scanner scanner, Printer printer, int rows) {
        printer.printInConsole("Enter a row number:\n");
        while (isChecked) {
            try {
                row = scanner.nextInt();
                while (row < 1) {
                    printer.printInConsole("Wrong input, enter the number bigger than 0.\n");
                    row = scanner.nextInt();
                }
                while (row > rows) {
                    printer.printInConsole("Wrong input, enter the number equal or less than rows.\n");
                    row = scanner.nextInt();
                }
                isChecked = false;
            } catch (InputMismatchException e) {
                printer.printInConsole("Wrong input, enter a row number.\n");
                scanner.next();
            }
        }
        return row;
    }

    public int getSeat(int seat, boolean isChecked, Scanner scanner, Printer printer, int seats) {
        printer.printInConsole("Enter a seat number in that row:\n");
        while (isChecked) {
            try {
                seat = scanner.nextInt();
                while (seat < 1) {
                    printer.printInConsole("Wrong input, enter the number bigger than 0.\n");
                    seat = scanner.nextInt();
                }
                while (seat > seats) {
                    printer.printInConsole("Wrong input, enter the number equal or less than seats.\n");
                    seat = scanner.nextInt();
                }
                isChecked = false;
            } catch (InputMismatchException e) {
                printer.printInConsole("Wrong input, enter a row number.\n");
                scanner.next();
            }
        }
        return seat;
    }


    //Checking if the cinema room has free seats.
    public boolean isFullCinema(String[][] arr, boolean fullCinema) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                fullCinema = !arr[i][j].equals("S");
            }
        }
        return fullCinema;
    }
}
