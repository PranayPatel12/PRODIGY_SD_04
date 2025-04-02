import java.util.Scanner;

public class SudokuSolver {
    private static final int SIZE = 9;

    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = 3 * (row / 3), startCol = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print((board[i][j] == 0 ? "." : board[i][j]) + " ");
            }
            System.out.println("|");
            if ((i + 1) % 3 == 0) System.out.println("+-------+-------+-------+");
        }
    }

    public static int[][] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[SIZE][SIZE];
        System.out.println("Enter the Sudoku puzzle row by row, use 0 for empty cells:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int value;
                while (true) {
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a number between 0 and 9.");
                        scanner.next();
                        continue;
                    }
                    value = scanner.nextInt();
                    if (value < 0 || value > 9) {
                        System.out.println("Invalid number! Enter a value between 0 and 9.");
                    } else {
                        break;
                    }
                }
                board[i][j] = value;
            }
        }
        scanner.close();
        return board;
    }

    public static void main(String[] args) {
        int[][] sudokuBoard = getUserInput();

        System.out.println("\nSudoku puzzle:");
        printBoard(sudokuBoard);

        if (solveSudoku(sudokuBoard)) {
            System.out.println("\nSolved Sudoku:");
            printBoard(sudokuBoard);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
