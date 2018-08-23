package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class EightQueens {

    static final int lineNum = 8;
    // 棋盘
    int[][] chessBoard = new int[lineNum][lineNum];

    // 临时布局
    private static List<String> tmpArr = new ArrayList<>();
    // 可能存在的布局组合
    private static List<List<String>> possibleList = new ArrayList<>();
    // 最终布局集合
    private static List<int[][]> eightQueenBoard = new ArrayList<>();

    public List<int[][]> printEightQueens() {

        chessBoard = new int[lineNum][lineNum];

        List<String> indexBoardList = getStringList();

        combine(0, lineNum, indexBoardList);

        for (int i = 0; i < possibleList.size(); i++) {
            int[][] tempChessBoard = arrangement(possibleList.get(i));
            if (tempChessBoard != null) {
                eightQueenBoard.add(tempChessBoard);
            }
        }

        printBoard();

        return eightQueenBoard;
    }

    private List<String> getStringList() {
        List<String> indexBoardList = Lists.newArrayList();
        for (int i = 0; i < lineNum; i++) {
            for (int j = 0; j < lineNum; j++) {
                indexBoardList.add(i + "" + j);
            }
        }
        return indexBoardList;
    }

    private void printBoard() {
        for (int i = 0; i < eightQueenBoard.size(); i++) {
            System.err.println("*** round " + (i + 1) + " ***");
            int[][] boardLine = eightQueenBoard.get(i);
            for (int j = 0; j < boardLine.length; j++) {
                for (int k = 0; k < boardLine[j].length; k++) {
                    System.err.print(JSONObject.toJSONString(boardLine[j][k]) + " ");
                }
                System.err.println();
            }
            System.err.println();
        }
    }

    private int[][] arrangement(List<String> rowAndCel) {
        int[][] tempArrs = new int[lineNum][lineNum];
        for (int i = 0; i < rowAndCel.size(); i++) {
            int row = Integer.valueOf(rowAndCel.get(i).substring(0, 1));
            int cel = Integer.valueOf(rowAndCel.get(i).substring(1, 2));
            if (checkQueens(tempArrs, row, cel)) {
                tempArrs[row][cel] = 1;
            } else {
                return null;
            }
        }
        return tempArrs;
    }

    public static void combine(int index, int k, List<String> arr) {
        if (k == 1) {
            for (int i = index; i < arr.size(); i++) {
                if (isIfExists(arr, i)) {
                    continue;
                }
                tmpArr.add(arr.get(i));
                //添加到可能的集合中
                possibleList.add(new ArrayList<>(tmpArr));
//                System.out.println(tmpArr.toString());
                tmpArr.remove(arr.get(i));
            }
        } else if (k > 1) {
            for (int i = index; i <= arr.size() - k; i++) {
                if (isIfExists(arr, i)) {
                    continue;
                }
                tmpArr.add(arr.get(i));
                combine(i + 1, k - 1, arr);
                tmpArr.remove(arr.get(i));
            }
        } else {
            return;
        }
    }

    private static boolean isIfExists(List<String> arr, int i) {
        boolean ifExists = false;
        for (int j = 0; j < tmpArr.size(); j++) {
            if (tmpArr.get(j).startsWith(arr.get(i).substring(0, 1))
                    || tmpArr.get(j).endsWith(arr.get(i).substring(1, 2))) {
                ifExists = true;
                break;
            }
        }
        return ifExists;
    }

    boolean checkQueens(int[][] tempBoard, int row, int cel) {
        // 对角线
        for (int i = 0; i < lineNum; i++) {
            for (int j = 0; j < lineNum; j++) {
                if (tempBoard[i][j] == 1) {
                    if (Math.abs(i - row) == Math.abs(j - cel)) {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < lineNum; i++) {
            if (i != cel && tempBoard[row][i] == 1) {
                return false;
            }
        }
        for (int j = 0; j < lineNum; j++) {
            if (j != row && tempBoard[j][cel] == 1) {
                return false;
            }
        }
        return true;
    }


    public static <T> List<List<T>> combinations(List<T> list, int k) {
        if (k == 0 || list.isEmpty()) {//去除K大于list.size的情况。即取出长度不足K时清除此list
            return Collections.emptyList();
        }
        if (k == 1) {//递归调用最后分成的都是1个1个的，从这里面取出元素
            return list.stream().map(e -> Stream.of(e).collect(toList())).collect(toList());
        }
        Map<Boolean, List<T>> headAndTail = split(list, 1);
        List<T> head = headAndTail.get(true);
        List<T> tail = headAndTail.get(false);
        List<List<T>> c1 = combinations(tail, (k - 1)).stream().map(e -> {
            List<T> l = new ArrayList<>();
            l.addAll(head);
            l.addAll(e);
            return l;
        }).collect(Collectors.toList());
        List<List<T>> c2 = combinations(tail, k);
        c1.addAll(c2);
        return c1;
    }

    /**
     * 根据n将集合分成两组
     **/
    public static <T> Map<Boolean, List<T>> split(List<T> list, int n) {
        return IntStream
                .range(0, list.size())
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, list.get(i)))
                .collect(partitioningBy(entry -> entry.getKey() < n, mapping(AbstractMap.SimpleEntry::getValue, toList())));
    }

}
