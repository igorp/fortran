//Game of Life implementation by Igor
public class Life {

    static int SIZE = 10;
    static int ITERATIONS = 15;
    static boolean[][] grid = new boolean[SIZE][SIZE];

    public static void main(String args[]) throws InterruptedException {

        boolean[][] originalGrid = new boolean[SIZE][SIZE];

        
        grid[1][2] = true;
        grid[2][1] = true;
        grid[2][2] = true;
        grid[3][2] = true;
        grid[2][3] = true;
        //grid[3][3] = true;
        grid[5][5] = true;
        grid[4][5] = true;

        //grid[0][2] = true;
       // grid[1][1] = true;
       // grid[1][3] = true;
       // grid[2][0] = true;
        
        
        
        for (int n = 0; n < ITERATIONS; n++) {
            printGrid();
            copyArray(grid, originalGrid);
            System.out.println();
            Thread.sleep(1000);

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    grid[i][j] = nextState(i, j, originalGrid);
                }
            }
        }
    }

    static boolean nextState(int i, int j, boolean[][] grid_orig) {
        //count how many neigbours cell has
        int neighbours = 0;

        //check perpendicular cells
        if (i + 1 < SIZE && grid_orig[i + 1][j]) {
            neighbours++;
        }
        if (i - 1 > -1 && grid_orig[i - 1][j]) {
            neighbours++;
        }
        if (j + 1 < SIZE && grid_orig[i][j + 1]) {
            neighbours++;
        }
        if (j - 1 > -1 && grid_orig[i][j - 1]) {
            neighbours++;
        }

        //check diagonal cells
        if (i + 1 < SIZE && j + 1 < SIZE && grid_orig[i + 1][j + 1]) {
            neighbours++;
        }
        if (i - 1 > -1 && j - 1 > -1 && grid_orig[i - 1][j - 1]) {
            neighbours++;
        }
        if (i + 1 < SIZE && j - 1 > -1 && grid_orig[i + 1][j - 1]) {
            neighbours++;
        }
        
       // if(i == 1 && j == 1) {
        //    System.out.println("i - 1 > 0: " + (i - 1 > 0));
        //}
        if (i - 1 > -1 && j + 1 < SIZE && grid_orig[i - 1][j + 1]) {
            neighbours++;
         //   System.out.println(i + " " + j + "HERE&");
        }
        if (grid[i][j]) {
       //     System.out.println(i + " " + j + " neighbours: " + neighbours);
        }

        if (grid_orig[i][j] && neighbours < 2) {
            return false;
        }
        //probably not needed
        if (grid_orig[i][j] && (neighbours == 2 || neighbours == 3)) {
            return true;
        }
        if (grid_orig[i][j] && neighbours > 3) {
            return false;
        }
        if (!grid_orig[i][j] && neighbours == 3) {
            return true;
        }
        return false;
    }

    static void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    static void copyArray(boolean[][] a, boolean[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[i][j] = a[i][j];
            }
        }
    }
}
