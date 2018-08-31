package com.mjy.cyber;

import com.google.common.collect.Lists;
import com.mjy.cyber.util.StringUtil;

import java.util.List;

public class MineField {

    private static int wight = 0;
    private static int height = 0;
    private static List<String> board = Lists.newArrayList();

    public static List<String> printMineField(List<String> commandList) {
        initBoard(commandList);
        for (int row = 0; row < height; row++) {
            String rowStr = board.get(row);
            for (int cell = 0; cell < wight; cell++) {
                String str = rowStr.charAt(cell) + "";
                if (".".equals(str)) {
                    rowStr = StringUtil.replaceIndex(rowStr, cell, getThunderNum(row, cell) + "");
                    board.set(row, rowStr);
                }
            }
        }
        for (String str : board) {
            System.err.println(str);
        }

        return board;
    }

    private static int getThunderNum(int row, int cell) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = cell - 1; j <= cell + 1; j++) {
                if (i != row || j != cell) {
                    try {
                        count += ("*".equals(board.get(i).charAt(j) + "")) ? 1 : 0;
                    } catch (Exception e) {
                    }
                }
            }
        }
        return count;
    }

    private static void initBoard(List<String> commandList) {
        height = Integer.valueOf(commandList.get(0).split(" ")[0]);
        wight = Integer.valueOf(commandList.get(0).split(" ")[1]);

        board = Lists.newArrayList();
        commandList.stream().forEach(line -> {
            if (!commandList.get(0).equals(line)) {
                board.add(line);
            }
        });
    }

}
