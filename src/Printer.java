public class Printer {
    public void printArray(String[][] array){
        System.out.print("Cinema:");
        for (String[] strings : array) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string + " ");
            }
        }
    }
    public void printMenu(){
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }
}