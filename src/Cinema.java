import java.text.DecimalFormat;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        int row = 0;
        int seat = 0;
        int rows = 0;
        int seats = 0;
        int price;
        int choice = 0;
        boolean isDone = false;
        boolean isValid;
        boolean fullCinema;
        int purchasedTickets = 0;
        int income = 0;
        int totalIncome;
        float percentages = 0;
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        ArrayManager arrayManager = new ArrayManager();
        Checker checker = new Checker();
        DecimalFormat format = new DecimalFormat("#,##0.00");

        //Entering the dimensions of the cinema room, checking whether the input is correct.
        rows = checker.getSeatsRows(rows, true, scanner, printer, "rows");
        seats = checker.getSeatsRows(seats, true, scanner, printer, "seats");

        //Calculation of the total income of the cinema room (formula consistent with the task on HyperSkill).
        int front = rows / 2;
        totalIncome = rows * seats > 60 ? front * seats * 10 + (rows - front) * seats * 8 : rows * seats * 10;

        //Creating a graphic visualization of the cinema room and filling it with seats available ("S").
        String[][] arr = new String[rows + 1][seats + 1];
        arrayManager.fillArrayBase(arr, rows, seats);

        //The heart of the console application. Displaying the menu and searching through the application enabled
        //by entering the number corresponding to the function presented in the menu.
        do {

            //Checking the menu selection input
            choice = checker.getChoice(choice, true, scanner, printer);

            switch (choice) {
                case 1:
                    printer.printArray(arr);
                    printer.printInConsole("\n");
                    break;
                case 2:

                    //Checking if the cinema hall is not full. If so, don't give the opportunity to buy a ticket.
                    //If not, provide instructions on how to buy a ticket.
                    fullCinema = checker.isFullCinema(arr, false);
                    if (fullCinema) {
                        printer.printInConsole("No seats available.\n");
                    } else {
                        do {

                            //Checking the input of the selected place of the cinema room. If the seat is available,
                            //change the seat to a purchased one and display the price of the ticket.
                            row = checker.getRow(row, true, scanner, printer, rows);
                            seat = checker.getSeat(seat, true, scanner, printer, seats);
                            if (arr[row][seat].equals("B")) {
                                isValid = false;
                                printer.printInConsole("That ticket has already been purchased!\n");
                            } else {
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

                        //Manage the stats of the cinema room after buying a ticket.
                        purchasedTickets += 1;
                        income += price;
                        percentages = ((float) purchasedTickets / (seats * rows)) * 100;
                    }
                    break;
                case 3:

                    //Display cinema room stats.
                    printer.printInConsole(String.format("Number of purchased tickets: %d\n", purchasedTickets));
                    printer.printInConsole(String.format("Percentage: %s\n", format.format(percentages)));
                    printer.printInConsole(String.format("Current income: $%d\n", income));
                    printer.printInConsole(String.format("Total income: $%d\n", totalIncome));
                    break;
                case 0:

                    //Exit the application by changing the loop condition.
                    isDone = true;
                    break;
                default:
                    printer.printInConsole("There is no option like this.\n");
                    break;
            }
        } while (!isDone);
    }
}