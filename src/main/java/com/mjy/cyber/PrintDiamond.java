package com.mjy.cyber;

import com.mjy.cyber.util.StringUtil;

public class PrintDiamond {

    public static void printDiamond(String diamond) {
        int length = Integer.valueOf(diamond.toUpperCase().charAt(0)) - Integer.valueOf('A') + 1;

        String[][] board = initBoard(length);

        setUpperHalf(length, board);

        setLowerHalf(length, board);

        printBoard(board);

    }

    private static void setLowerHalf(int length, String[][] board) {
        for (int i = length; i < board.length; i++) {
            board[i] = board[2 * length - i - 2];
        }
    }

    private static void setUpperHalf(int length, String[][] board) {
        for (int i = 0; i < length; i++) {
            int index1 = length - i - 1;
            int index2 = length + i - 1;
            board[i][index1] = (char) (65 + i) + "";
            board[i][index2] = (char) (65 + i) + "";
        }
    }

    private static void printBoard(String[][] board) {
        for (String[] strs : board) {
            System.err.println(StringUtil.splicing(strs));
        }
    }

    private static String[][] initBoard(int length) {
        String[][] board = new String[2 * length - 1][2 * length - 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = " ";
            }
        }
        return board;
    }

}
