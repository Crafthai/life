import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int size = 25;
        boolean[][] life = new boolean[size][size];
        boolean[][] lifeUpdate = new boolean[size][size];
        StringBuilder[] row = new StringBuilder[size];
        Random born = new Random();
        char goAgain = 'y';
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < size; i++) {
            row[i] = new StringBuilder("-------------------------");
            for (int j = 0; j < size; j++) {
                if (born.nextInt(100) < 25) {
                    life[i][j] = true;
                    lifeUpdate[i][j] = true;
                }
            }
        }

        //while(true) { //remove for infinite loop
        while (goAgain == 'y') {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (life[i][j]) {

                        if (liveNeighbors(life, i, j) < 2) {
                            lifeUpdate[i][j] = false;
                        } else if (liveNeighbors(life, i, j) == 2 || liveNeighbors(life, i, j) == 3) {
                            lifeUpdate[i][j] = true;
                        } else if (liveNeighbors(life, i, j) > 3) {
                            lifeUpdate[i][j] = false;
                        }
                    } else if (!life[i][j]) {
                        if (liveNeighbors(life, i, j) == 3) {
                            lifeUpdate[i][j] = true;
                        }
                    }
                }
            }
            life = lifeUpdate;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (life[i][j]) {
                        row[i].replace(j, j + 1, "o");
                    } else if (!life[i][j]) {
                        row[i].replace(j, j + 1, "-");
                    }
                }
            }


            for (int i = 0; i < size; i++) {
                System.out.println(row[i].toString());
            }
            System.out.println("\n");
            System.out.println("type 'y' for next generation");
            goAgain = scan.next().charAt(0);

        }
    }

    private static int liveNeighbors(boolean[][] life, int row, int column) {
        int amount = 0;

        if (row - 1 < 0 && column - 1 < 0) {
            if (life[row][column + 1]) {
                amount++;
            }
            if (life[row + 1][column + 1]) {
                amount++;
            }
            if (life[row + 1][column]) {
                amount++;
            }
        } else if (row - 1 < 0 && column + 1 > 24) {
            if (life[row][column - 1]) {
                amount++;
            }
            if (life[row + 1][column - 1]) {
                amount++;
            }
            if (life[row + 1][column]) {
                amount++;
            }
        } else if (row + 1 > 24 && column - 1 < 0) {
            if (life[row - 1][column]) {
                amount++;
            }
            if (life[row - 1][column + 1]) {
                amount++;
            }
            if (life[row][column + 1]) {
                amount++;
            }
        } else if (row + 1 > 24 && column + 1 > 24) {
            if (life[row][column - 1]) {
                amount++;
            }
            if (life[row - 1][column - 1]) {
                amount++;
            }
            if (life[row - 1][column]) {
                amount++;
            }

        } else if (row - 1 < 0) {
            if (life[row][column - 1]) {
                amount++;
            }
            if (life[row + 1][column - 1]) {
                amount++;
            }
            if (life[row + 1][column]) {
                amount++;
            }
            if (life[row][column + 1]) {
                amount++;
            }
            if (life[row + 1][column + 1]) {
                amount++;
            }
        } else if (column - 1 < 0) {
            if (life[row][column + 1]) {
                amount++;
            }
            if (life[row + 1][column + 1]) {
                amount++;
            }
            if (life[row + 1][column]) {
                amount++;
            }
            if (life[row - 1][column]) {
                amount++;
            }
            if (life[row - 1][column + 1]) {
                amount++;
            }
        } else if (column + 1 > 24) {
            if (life[row - 1][column]) {
                amount++;
            }
            if (life[row - 1][column - 1]) {
                amount++;
            }
            if (life[row][column - 1]) {
                amount++;
            }
            if (life[row + 1][column - 1]) {
                amount++;
            }
            if (life[row + 1][column]) {
                amount++;
            }

        } else if (row + 1 > 24) {
            if (life[row][column + 1]) {
                amount++;
            }
            if (life[row - 1][column]) {
                amount++;
            }
            if (life[row][column - 1]) {
                amount++;
            }
            if (life[row - 1][column - 1]) {
                amount++;
            }
            if (life[row - 1][column + 1]) {
                amount++;
            }

        } else {
            if (life[row + 1][column]) {
                amount++;
            }
            if (life[row][column + 1]) {
                amount++;
            }
            if (life[row + 1][column + 1]) {
                amount++;
            }
            if (life[row - 1][column]) {
                amount++;
            }
            if (life[row][column - 1]) {
                amount++;
            }
            if (life[row - 1][column - 1]) {
                amount++;
            }
            if (life[row - 1][column + 1]) {
                amount++;
            }
            if (life[row + 1][column - 1]) {
                amount++;
            }
        }
        return amount;
    }
}


