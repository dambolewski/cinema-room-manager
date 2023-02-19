import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        int rows;
        int row = 0;
        int seats;
        int seat = 0;
        int price;
        int choice;
        boolean isDone = false;
        boolean isValid;
        int purchasedTickets = 0;
        int income = 0;
        int totalIncome;
        float percentages = 0;

        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        ArrayManager arrayManager = new ArrayManager();
        DecimalFormat format = new DecimalFormat("#,##0.00");


        printer.printInConsole("Enter the number of rows:\n");
        rows = scanner.nextInt();
        printer.printInConsole("Enter the number of seats in each row:\n");
        seats = scanner.nextInt();


        int front = rows / 2;
        totalIncome = rows * seats > 60 ? front * seats * 10 + (rows - front) * seats * 8 : rows * seats * 10;

        String[][] arr = new String[rows + 1][seats + 1];
        arrayManager.fillArrayBase(arr, rows, seats);

        do {
            printer.printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printer.printArray(arr);
                    printer.printInConsole("\n");
                    break;
                case 2:
                    do {
                        try {
                            printer.printInConsole("Enter a row number:\n");
                            row = scanner.nextInt();
                            printer.printInConsole("Enter a seat number in that row:\n");
                            seat = scanner.nextInt();
                            if (arr[row][seat].equals("B")) {
                                isValid = false;
                                printer.printInConsole("That ticket has already been purchased!\n");
                            } else {
                                isValid = true;
                            }

                        } catch (InputMismatchException e) {
                            printer.printInConsole("Wrong input!\n");
                            isValid = true;
                        }
                    } while (!isValid);

                    if ((rows * seats < 60)) {
                        price = 10;
                    } else if ((rows * seats > 60 && row <= rows / 2)) {
                        price = 10;
                    } else {
                        price = 8;
                    }
                    printer.printInConsole(String.format("Ticket price: $%d\n", price));
                    arrayManager.arrayPlaceBought(arr, row, seat);
                    purchasedTickets += 1;
                    income += price;
                    percentages = ((float) purchasedTickets / (seats * rows)) * 100;
                    break;
                case 3:
                    printer.printInConsole(String.format("Number of purchased tickets: %d\n", purchasedTickets));
                    printer.printInConsole(String.format("Percentage: %s\n", format.format(percentages)));
                    printer.printInConsole(String.format("Current income: $%d\n", income));
                    printer.printInConsole(String.format("Total income: $%d\n", totalIncome));
                    break;

                case 0:
                    isDone = true;
                    break;
                default:
                    printer.printInConsole("There is no option like this!\n");
                    break;
            }
        } while (!isDone);

    }
}