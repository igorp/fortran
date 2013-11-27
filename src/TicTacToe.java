
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static int[][] board = new int[3][3];
    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {

        int turnCounter = 0;

        drawBoard();
        while (true) {
            turnCounter++;
            enterUserInput();
            if (checkWinningConditions(1)) {
                drawBoard();
                System.out.println("You won!");
                break;
            }
            if (turnCounter > 8) {
                drawBoard();
                System.out.println("It's a draw.");
                break;
            }

            turnCounter++;
            enterComputerInput();
            if (checkWinningConditions(2)) {
                drawBoard();
                System.out.println("The computer won!");
                break;
            }
            drawBoard();
        }
    }

    public static void drawBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String symbol;
                switch (board[i][j]) {
                    case 0:
                        symbol = " ";
                        break;
                    case 1:
                        symbol = "X";
                        break;
                    case 2:
                        symbol = "O";
                        break;
                    default:
                        symbol = " ";
                        break;
                }

                System.out.print("[" + symbol + "]");
            }
            System.out.println();
        }
    }

    public static void enterUserInput() {
        boolean validInput = false;
        do {
            System.out.println("Enter coordinates (eg. '0 1'): ");
            String coordinates = input.nextLine();
            String[] splitArray = coordinates.split("\\s+");
            int x = Integer.parseInt(splitArray[0]);
            int y = Integer.parseInt(splitArray[1]);
            if (x < 3 && x > -1 && y < 3 && y > -1) {
                if (board[x][y] == 0) {
                    board[x][y] = 1;
                    validInput = true;
                }
            }
        } while (validInput == false);
    }

    public static void enterComputerInput() {
        Random rand = new Random();
        boolean canEnd = false;
        while (!canEnd) {
            int x = rand.nextInt(3);
            int y = rand.nextInt(3);
            if (board[x][y] == 0) {
                board[x][y] = 2;
                canEnd = true;
            }
        }
    }

    public static boolean checkWinningConditions(int player) {
        int rowCounter = 0;
        int columnCounter = 0;
        int diagonalBackCounter = 0;
        int diagonalForwardCounter = 0;

        //check rows and columns and diagnon
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == player) {
                    rowCounter++;
                }
                if (board[j][i] == player) {
                    columnCounter++;
                }
            }
            if (rowCounter == 3 || columnCounter == 3) {
                return true;
            }
            rowCounter = 0;
            columnCounter = 0;

            if (board[i][i] == player) {
                diagonalBackCounter++;
            }
            if (board[i][2 - i] == player) {
                diagonalForwardCounter++;
            }
        }
        if (diagonalBackCounter == 3 || diagonalForwardCounter == 3) {
            return true;
        }
        return false;
    }
}