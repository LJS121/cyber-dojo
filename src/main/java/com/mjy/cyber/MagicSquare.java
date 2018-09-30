package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class MagicSquare {

    private static final int rate = 10;

    private static volatile List<List<Integer>> magicList = Lists.newArrayList();
    private static volatile List<Double> magicNumberList = Lists.newArrayList();
    private static volatile List<Integer> list = Lists.newArrayList();

    public static Double findMagicNumber(List<Double> doubleList) {
        initCollection(doubleList);

        //获取所有可以坐标组合
        List<String> tempStringList = Anagrams2.of("012345678");

        for (String strBoard : tempStringList) {
            List<Integer> integerList = getIntegerListByBoard(strBoard);
            if (validateMagicNum(integerList)) {
                magicList.add(integerList);
                magicNumberList.add(Double.valueOf(getMagicNum(integerList)) / rate);
            }
        }
        System.out.println("magicList == " + JSONObject.toJSONString(magicList));
        System.out.println("magicNumberList == " + JSONObject.toJSONString(magicNumberList));

        return (magicNumberList != null && magicNumberList.size() > 0) ? magicNumberList.get(0) : null;
    }

    private static List<Integer> getIntegerListByBoard(String strBoard) {
        List<Integer> newIntegerList = Lists.newArrayList();
        for (int i = 0; i < list.size(); i++) {
            newIntegerList.add(list.get(strBoard.indexOf(i + "")));
        }
        return newIntegerList;
    }

    public static boolean validateMagicNum(List<Integer> integerList) {
        int magicNum = integerList.get(0) + integerList.get(1) + integerList.get(2);
        if (integerList.get(0) + integerList.get(3) + integerList.get(6) == magicNum
                && integerList.get(0) + integerList.get(4) + integerList.get(8) == magicNum
                && integerList.get(1) + integerList.get(4) + integerList.get(7) == magicNum
                && integerList.get(2) + integerList.get(4) + integerList.get(6) == magicNum
                && integerList.get(2) + integerList.get(5) + integerList.get(8) == magicNum
                && integerList.get(3) + integerList.get(4) + integerList.get(5) == magicNum
                && integerList.get(6) + integerList.get(7) + integerList.get(8) == magicNum) {
            return true;
        }
        return false;
    }

    private static int getMagicNum(List<Integer> integerList) {
        return integerList.get(0)+ integerList.get(1) + integerList.get(2);
    }


    private static void initCollection(List<Double> doubleList) {
        list = Lists.newArrayList();
        doubleList.stream().forEach(value -> list.add(Double.valueOf(value * rate).intValue()));
        Collections.sort(list);

        magicList = Lists.newArrayList();
        magicNumberList = Lists.newArrayList();
    }
}
