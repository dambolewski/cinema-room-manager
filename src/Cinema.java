import java.text.DecimalFormat;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Printer printer = new Printer();
        ArrayManager ar = new ArrayManager();
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
        DecimalFormat df = new DecimalFormat("#,##0.00");


        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = sc.nextInt();


        int front = rows / 2;
        totalIncome = rows * seats > 60 ? front * seats * 10 + (rows - front) * seats * 8 : rows * seats * 10;

        String[][] arr = new String[rows + 1][seats + 1];
        ar.fillArrayBase(arr, rows, seats);

        do {
            printer.printMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printer.printArray(arr);
                    System.out.println();
                    break;
                case 2:
                    do {
                        try {
                            System.out.println("Enter a row number:");
                            row = sc.nextInt();
                            System.out.println("Enter a seat number in that row:");
                            seat = sc.nextInt();
                            if (arr[row][seat].equals("B")) {
                                isValid = false;
                                System.out.println("That ticket has already been purchased!");
                            } else {
                                isValid = true;
                            }

                        }catch (Exception e){
                            System.out.println("Wrong input!");
                            isValid = false;
                        }
                    } while (!isValid);

                    if ((rows * seats < 60)) {
                        price = 10;
                    } else if ((rows * seats > 60 && row <= rows / 2)) {
                        price = 10;
                    } else {
                        price = 8;
                    }
                    System.out.println("Ticket price: $" + price);
                    ar.arrayPlaceBought(arr, row, seat);
                    purchasedTickets += 1;
                    income = income + price;
                    percentages = ((float) purchasedTickets/(seats*rows))*100;
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: " + purchasedTickets);
                    System.out.println("Percentage: " + df.format(percentages) + "%");
                    System.out.println("Current income: $" + income);
                    System.out.println("Total income: $" + totalIncome);
                    break;

                case 0:
                    isDone = true;
                    break;
                default:
                    System.out.println("There is no option like this!");
                    break;
            }
        } while (!isDone);

    }
}