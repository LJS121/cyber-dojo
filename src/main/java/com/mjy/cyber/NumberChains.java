package com.mjy.cyber;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;
import com.mjy.cyber.util.StringUtil;

public class NumberChains {

    public static List<Integer> getNumberChains(int number) {

        List<Integer> numberChainList = Lists.newArrayList();
        while (true) {
            number = calc(number);
            if (numberChainList.contains(number)) {
                numberChainList.add(number);
                System.out.println("链长" + numberChainList.size());
                return numberChainList;
            } else {
                numberChainList.add(number);
            }
        }
    }

    private static int calc(int number) {

        int firstNum = getDescNumber(number);
        int secondNum = getAscNumber(number);
        number = firstNum - secondNum;
        System.out.println(String.format("%s - %s = %s", firstNum, secondNum, number));
        return number;
    }

    private static int getAscNumber(int number) {

        String[] strings = StringUtil.toStringArray(number + "");
        Arrays.sort(strings);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        return StringUtil.toIntValue(sb.toString());
    }

    private static int getDescNumber(int number) {

        String[] strings = StringUtil.toStringArray(number + "");
        Arrays.sort(strings);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[strings.length - i - 1]);
        }
        return StringUtil.toIntValue(sb.toString());
    }

}
