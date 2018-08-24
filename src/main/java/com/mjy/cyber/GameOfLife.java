package com.mjy.cyber;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class GameOfLife {

    int length = 8;
    int height = 4;

    int[][] board = new int[height][length];

    public void setPointAlive(int row, int cell) {
        this.board[row][cell] = 1;
    }


    public List<int[][]> findAllBoardList() {
        //先获取所有可能的集合，非边线，非已存在
        Set<String> set = findAllPossiblePoint();

        //生成board

        return createBoardList(set);
    }

    private List<int[][]> createBoardList(Set<String> checkedSet) {
        List<int[][]> boardList = Lists.newArrayList();
        for (String pointString : checkedSet) {
            int[][] tempBoard = this.board.clone();
            tempBoard[Integer.valueOf(pointString.charAt(0) + "")][Integer.valueOf(pointString.charAt(1) + "")] = 1;
            boardList.add(tempBoard);
        }
        return boardList;
    }

    private Set<String> findAllPossiblePoint() {
        Set<String> set = Sets.newHashSet();
        for (int row = 1; row < height - 1; row++) {
            for (int cell = 1; cell < length - 1; cell++) {
                if (this.board[row][cell] == 1) {
                    setAroundPoint(set, row, cell);
                }
            }
        }

        //再校验可能集合的可行性，2-3个邻居
        Set<String> setResult = Sets.newHashSet();
        for (String possiblePoint : set) {
            if (checkTrue(possiblePoint)) {
                setResult.add(possiblePoint);
            }
        }

        return setResult;
    }

    private void setAroundPoint(Set<String> set, int row, int cell) {
        if (row - 1 > 0 && this.board[row - 1][cell] == 0) {
            set.add((row - 1) + "" + cell);
        }
        if (row + 1 < (height - 1) && this.board[row + 1][cell] == 0) {
            set.add((row + 1) + "" + cell);
        }
        if (cell - 1 > 0 && this.board[row][cell - 1] == 0) {
            set.add(row + "" + (cell - 1));
        }
        if (cell + 1 < (length - 1) && this.board[row][cell + 1] == 0) {
            set.add(row + "" + (cell + 1));
        }
    }

    private boolean checkTrue(String possiblePoint) {
        int pointX = Integer.valueOf(possiblePoint.charAt(0) + "");
        int pointY = Integer.valueOf(possiblePoint.charAt(1) + "");

        int upper = this.board[pointX - 1][pointY];
        int lower = this.board[pointX + 1][pointY];
        int left = this.board[pointX][pointY - 1];
        int right = this.board[pointX][pointY + 1];

        int sum = upper + lower + left + right;
        return (sum == 2 || sum == 3) ? true : false;
    }

    public void setLength(int length) {
        this.length = length;
        this.board = new int[this.height][this.length];
    }

    public void setHeight(int height) {
        this.height = height;
        this.board = new int[this.height][this.length];
    }
}
