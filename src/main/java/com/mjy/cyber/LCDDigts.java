package com.mjy.cyber;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class LCDDigts {

    public static final String spot = ".";
    public static final String transverse = "_";
    public static final String vertical = "|";
    public static final String space = " ";
    private static StringBuilder stringBuilder;

    public static void printLCDDigits(int input) {
        List<Integer> numberList = parseInput(input);
        List<String[][]> digitsList = getDigits(numberList);

        printDigitsList(digitsList);
    }

    private static void printDigitsList(List<String[][]> digitsList) {
        String[][] printArrs = new String[3][digitsList.size() * 4 - 1];

        for (int i = 0; i < digitsList.size(); i++) {
            String[][] stringArrs = digitsList.get(i);
            for (int row = 0; row < stringArrs.length; row++) {
                String[] stringArr = stringArrs[row];
                for (int j = 0; j < stringArr.length; j++) {
                    printArrs[row][i * 4 + j] = stringArr[j];
                }
                if (i < digitsList.size() - 1) {
                    printArrs[row][i * 4 + 3] = space;
                }
            }
        }

        for (String[] stringArrs : printArrs) {
            stringBuilder = new StringBuilder();
            Arrays.stream(stringArrs).forEach(value -> stringBuilder.append(value));
            System.err.println(stringBuilder);
        }
    }

    private static List<String[][]> getDigits(List<Integer> numberList) {
        List<String[][]> digitsList = Lists.newArrayList();

        for (Integer number : numberList) {
            digitsList.add(getNumberDigit(number));
        }

        return digitsList;
    }

    private static String[][] getNumberDigit(Integer number) {
        String[][] lcd = initLcd();

        switch (number) {
            case 0:
                lcd[0][1] = transverse;
                lcd[1][0] = vertical;
                lcd[1][2] = vertical;
                lcd[2][0] = vertical;
                lcd[2][1] = transverse;
                lcd[2][2] = vertical;
                break;
            case 1:
                lcd[1][2] = vertical;
                lcd[2][2] = vertical;
                break;
            case 2:
                lcd[0][1] = transverse;
                lcd[1][1] = transverse;
                lcd[1][2] = vertical;
                lcd[2][0] = vertical;
                lcd[2][1] = transverse;
                break;
            case 3:
                lcd[0][1] = transverse;
                lcd[1][1] = transverse;
                lcd[1][2] = vertical;
                lcd[2][1] = transverse;
                lcd[2][2] = vertical;
                break;
            case 4:
                lcd[1][0] = vertical;
                lcd[1][1] = transverse;
                lcd[1][2] = vertical;
                lcd[2][2] = vertical;
                break;
            case 5:
                lcd[0][1] = transverse;
                lcd[1][0] = vertical;
                lcd[1][1] = transverse;
                lcd[2][1] = transverse;
                lcd[2][2] = vertical;
                break;
            case 6:
                lcd[0][1] = transverse;
                lcd[1][0] = vertical;
                lcd[1][1] = transverse;
                lcd[2][0] = vertical;
                lcd[2][1] = transverse;
                lcd[2][2] = vertical;
                break;
            case 7:
                lcd[0][1] = transverse;
                lcd[1][2] = vertical;
                lcd[2][2] = vertical;
                break;
            case 8:
                lcd[0][1] = transverse;
                lcd[1][0] = vertical;
                lcd[1][1] = transverse;
                lcd[1][2] = vertical;
                lcd[2][0] = vertical;
                lcd[2][1] = transverse;
                lcd[2][2] = vertical;
                break;
            case 9:
                lcd[0][1] = transverse;
                lcd[1][0] = vertical;
                lcd[1][1] = transverse;
                lcd[1][2] = vertical;
                lcd[2][2] = vertical;
                break;
        }
        return lcd;
    }

    private static String[][] initLcd() {
        String[][] lcd = new String[3][3];
        for (int i = 0; i < lcd.length; i++) {
            for (int j = 0; j < lcd[i].length; j++) {
                lcd[i][j] = spot;
            }
        }
        return lcd;
    }

    private static List<Integer> parseInput(int input) {
        List<Integer> numberList = Lists.newArrayList();
        char[] chars = String.valueOf(input).toCharArray();
        for (char _char : chars) {
            numberList.add(Integer.valueOf(_char + ""));
        }
        return numberList;
    }


}
