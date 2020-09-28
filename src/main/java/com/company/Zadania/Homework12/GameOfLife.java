package com.company.Zadania.Homework12;


import java.util.Scanner;

public class GameOfLife {

    private static final int HEIGHT = 5;
    private static final int WIDTH = 15;

    private static final boolean[][] initialBoard = new boolean[HEIGHT][WIDTH];
    private static final boolean[][] newGenerationBoard = new boolean[HEIGHT][WIDTH];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearBoard();

        initialBoard[2][2] = true;
        initialBoard[2][3] = true;
        initialBoard[2][4] = true;
        initialBoard[3][4] = true;

        printBoard(initialBoard);

        while (true) {
            scanner.nextLine();
            calculateNextGeneration();
            printBoard(initialBoard);
        }

    }

    private static void clearBoard() {
        for (int i = 0; i < initialBoard.length; i++) {
            for (int j = 0; j < initialBoard[0].length; j++) {
                initialBoard[i][j] = false;
            }
        }
    }

    private static void printBoard(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j]) {
                    System.out.print("#");
                } else {
                    System.out.print("_");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    private static void calculateNextGeneration() {
        for (int i = 0; i < initialBoard.length; i++) {
            for (int j = 0; j < initialBoard[0].length; j++) {
                if (!initialBoard[i][j] && countNeighbours(initialBoard, i, j) == 3) {
                    newGenerationBoard[i][j] = true;
                } else if (initialBoard[i][j]) {
                    if (countNeighbours(initialBoard, i, j) == 2 || countNeighbours(initialBoard, i, j) == 3) {
                        newGenerationBoard[i][j] = true;
                    } else {
                        newGenerationBoard[i][j] = false;
                    }
                }
            }
        }

        copyNextGenBoardToInitialBoard();
    }

    private static int countNeighbours(boolean[][] board, int i, int j) {
        int counter = 0;

        if (i < board.length - 1 && board[i + 1][j]) {
            counter++;
        }
        if (j < board[0].length - 1 && board[i][j + 1]) {
            counter++;
        }
        if (i > 0 && board[i - 1][j]) {
            counter++;
        }
        if (j > 0 && board[i][j - 1]) {
            counter++;
        }
        if (j > 0 && i > 0 && board[i - 1][j - 1]) {
            counter++;
        }
        if (j > 0 && i < board.length - 1 && board[i + 1][j - 1]) {
            counter++;
        }
        if (j < board[0].length - 1 && i > 0 && board[i - 1][j + 1]) {
            counter++;
        }
        if (j < board[0].length - 1 && i < board.length - 1 && board[i + 1][j + 1]) {
            counter++;
        }

        return counter;
    }

    private static void copyNextGenBoardToInitialBoard() {
        for (int i = 0; i < newGenerationBoard.length; i++) {
            for (int j = 0; j < newGenerationBoard[0].length; j++) {
                initialBoard[i][j] = newGenerationBoard[i][j];
            }
        }
    }

    // 1D array
    // [1, 2, 3, 4]

    // 2d
    // array[0]
//    [
//    [1, 2, 3, 4],
//    [1, 2, 3, 4]
//    ]
}

