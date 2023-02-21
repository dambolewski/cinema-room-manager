public class ArrayManager {

    //Filling the cinema room (in the form of a 2-dimension array) with accessible places
    public void fillArrayBase(String[][] arr, int x, int y) {
        for (int i = 0; i < x + 1; i++) {
            for (int j = 0; j < y + 1; j++) {
                arr[0][0] = " ";
                arr[0][j] = String.valueOf(j);
                arr[i][0] = String.valueOf(i);
                if (arr[i][j] == null) {
                    arr[i][j] = "S";
                }
            }
        }
    }

    //Changing the seat available in the cinema room to a purchased one.
    public void arrayPlaceBought(String[][] arr, int x, int y) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[x][y].equals("S")) {
                    arr[x][y] = "B";
                    break;
                }
            }
        }
    }
}
