public class Printer {

    //Printing cinema room (case 1:)
    public void printArray(String[][] array) {
        printInConsole("Cinema:");
        for (String[] strings : array) {
            printInConsole("\n");
            for (String string : strings) {
                printInConsole(string + " ");
            }
        }
    }

    //Application menu printing used with input checking.
    public void printMenu() {
        printInConsole("1. Show the seats\n");
        printInConsole("2. Buy a ticket\n");
        printInConsole("3. Statistics\n");
        printInConsole("0. Exit\n");
    }

    public void printInConsole(String s) {
        System.out.print(s);
    }
}