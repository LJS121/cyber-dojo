package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

public class SaddlePoints {

    public static String findSaddlePoints(int[][] board) {
        List<Integer> list = Lists.newArrayList();
        for (int row = 0; row < board.length; row++) {
            for (int cel = 0; cel < board[row].length; cel++) {
                if (checkIfSaddle(board, row, cel)) {
                    list.add(board[row][cel]);
                }
            }
        }
        if (list.size() > 0) {
            return "saddle points: " + JSONObject.toJSONString(list);
        } else {
            return "No saddle points";
        }

    }

    private static boolean checkIfSaddle(int[][] board, int row, int cel) {
        if (checkRowNotAccord(board[row], board[row][cel])) {
            return false;
        }
        if (checkCelNotAccord(board, cel, board[row][cel])) {
            return false;
        }
        return true;
    }

    private static boolean checkCelNotAccord(int[][] board, int cel, int point) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][cel] > point) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRowNotAccord(int[] ints, int point) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > point) {
                return true;
            }
        }
        return false;
    }

}
