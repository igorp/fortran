//Game of Life implementation by Igor
public class Life {

    static int SIZE = 10;
    static int ITERATIONS = 10;
    static boolean[][] grid = new boolean[SIZE][SIZE];

    public static void main(String args[]) throws InterruptedException {

        boolean[][] originalGrid = new boolean[SIZE][SIZE];

        //set the first generation shape
        grid[4][5] = true;
        grid[5][4] = true;
        grid[5][5] = true;
        grid[5][6] = true;
        grid[6][5] = true;

        for (int n = 0; n < ITERATIONS; n++) {
            printGrid();
            copyArray(grid, originalGrid);
            System.out.println();
            Thread.sleep(500);

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    grid[i][j] = nextState(i, j, originalGrid);
                }
            }
        }
    }

    static boolean nextState(int i, int j, boolean[][] grid) {
        int neighbours = 0;

        //check perpendicular cells
        if (i + 1 < SIZE && grid[i + 1][j]) {
            neighbours++;
        }
        if (i - 1 > -1 && grid[i - 1][j]) {
            neighbours++;
        }
        if (j + 1 < SIZE && grid[i][j + 1]) {
            neighbours++;
        }
        if (j - 1 > -1 && grid[i][j - 1]) {
            neighbours++;
        }

        //check diagonal cells
        if (i + 1 < SIZE && j + 1 < SIZE && grid[i + 1][j + 1]) {
            neighbours++;
        }
        if (i - 1 > -1 && j - 1 > -1 && grid[i - 1][j - 1]) {
            neighbours++;
        }
        if (i + 1 < SIZE && j - 1 > -1 && grid[i + 1][j - 1]) {
            neighbours++;
        }
        if (i - 1 > -1 && j + 1 < SIZE && grid[i - 1][j + 1]) {
            neighbours++;
        }

        if (grid[i][j] && neighbours < 2) {
            return false;
        }
        if (grid[i][j] && (neighbours == 2 || neighbours == 3)) {
            return true;
        }
        if (grid[i][j] && neighbours > 3) {
            return false;
        }
        if (!grid[i][j] && neighbours == 3) {
            return true;
        }
        return false;
    }

    static void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j]) {
                    System.out.print("O ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    //copy array from a to b
    static void copyArray(boolean[][] a, boolean[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[i][j] = a[i][j];
            }
        }
    }
}
