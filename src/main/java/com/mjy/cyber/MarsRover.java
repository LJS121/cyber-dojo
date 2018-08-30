package com.mjy.cyber;

import com.google.common.collect.Lists;
import com.mjy.cyber.util.StringUtil;

import java.util.List;

public class MarsRover {

    private static final String north = "N";
    private static final String south = "S";
    private static final String east = "E";
    private static final String west = "W";
    private static final String left = "L";
    private static final String right = "R";
    private static final String move = "M";
    private static int max_x = 0;
    private static int max_y = 0;
    private static int x = 0;
    private static int y = 0;
    private static String direction = north;
    private static String space = " ";

    public static List<String> marsRover(List<String> commandList) {
        List<String> directionList = Lists.newArrayList();
        setBoundary(commandList);

        exec(commandList, directionList);

        return directionList;
    }

    private static void exec(List<String> commandList, List<String> directionList) {
        for (int i = 1; i <= commandList.size() / 2; i++) {
            setStatus(commandList, i);
            for (String command : StringUtil.toStringArray(commandList.get(2 * i))) {
                execCommand(command);
            }
            directionList.add(String.format("%s %s %s", x, y, direction));
        }
    }

    private static void setStatus(List<String> commandList, int i) {
        x = Integer.valueOf(commandList.get(2 * i - 1).split(space)[0]);
        y = Integer.valueOf(commandList.get(2 * i - 1).split(space)[1]);
        direction = commandList.get(2 * i - 1).split(space)[2];
    }

    private static void execCommand(String command) {
        if (left.equals(command)) {
            trunLeft();
        } else if (right.equals(command)) {
            trunRight();
        } else {
            execMove();
        }
    }

    private static void execMove() {
        if (north.equals(direction)) {
            y++;
        } else if (south.equals(direction)) {
            y--;
        } else if (west.equals(direction)) {
            x--;
        } else if (east.equals(direction)) {
            x++;
        }
    }

    private static void trunRight() {
        if (north.equals(direction)) {
            direction = east;
        } else if (south.equals(direction)) {
            direction = west;
        } else if (west.equals(direction)) {
            direction = north;
        } else if (east.equals(direction)) {
            direction = south;
        }
    }

    private static void trunLeft() {
        if (north.equals(direction)) {
            direction = west;
        } else if (south.equals(direction)) {
            direction = east;
        } else if (west.equals(direction)) {
            direction = south;
        } else if (east.equals(direction)) {
            direction = north;
        }
    }

    private static void setBoundary(List<String> commandList) {
        max_x = Integer.valueOf(commandList.get(0).split(" ")[0]);
        max_y = Integer.valueOf(commandList.get(0).split(" ")[1]);
    }

}
