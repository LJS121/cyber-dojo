package com.mjy.cyber;

import org.junit.Test;

import com.mjy.cyber.util.MathUtil;

public class SaddlePointsTest {

    @Test
    public void saddle_points() {
        // given
        int[][] board = initBoard();

        // when
        String saddlePoints = SaddlePoints.findSaddlePoints(board);

        // then
        System.err.println(saddlePoints);
    }

    private int[][] initBoard() {
        int[][] board = new int[5][5];

        for (int row = 0; row < board.length; row++) {
            for (int cel = 0; cel < board[row].length; cel++) {
                board[row][cel] = MathUtil.randomInt(11, 56);
                System.err.print(board[row][cel] + " ");
            }
            System.err.println();
        }
        return board;
    }
}
