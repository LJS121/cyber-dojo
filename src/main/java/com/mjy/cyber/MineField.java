package com.mjy.cyber;

import com.mjy.cyber.util.StringUtil;

import java.util.List;

public class MineField {


    private static String[][] board = new String[3][4];

    public static void printMineField(List<String> commandList) {
        String line1 = commandList.get(0);
        board = new String[StringUtil.toIntValue(StringUtil.toStringArray(line1)[0])][StringUtil.toIntValue(StringUtil.toStringArray(line1)[1])];

    }

}
