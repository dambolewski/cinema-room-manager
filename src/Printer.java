public class Printer {
    public void printArray(String[][] array){
        printInConsole("Cinema:");
        for (String[] strings : array) {
            printInConsole("\n");
            for (String string : strings) {
                printInConsole(string + " ");
            }
        }
    }
    public void printMenu(){
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public void printInConsole(String s){
        System.out.print(s);
    }
}