package com.mjy.cyber;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams2 {

    public static List<String> of(String str) {
        List<String> resultList = Lists.newArrayList();
        if ("".equals(str) || str.length() == 1) {
            return Arrays.asList(str);
        }
        for (int i = 0; i < str.length(); i++) {
            List<String> ofList = of(dropChar(str, i));
            for (String string : ofList) {
                resultList.add(str.charAt(i) + string);
            }
        }
        return resultList;
    }

    // bir
    private static String dropChar(String str, int index) {
        return str.replaceFirst(str.charAt(index) + "", "");
    }

    public static List<List<Integer>> of(ArrayList<Integer> sourceList) {
        List<Integer> targetList = (List<Integer>) sourceList.clone();
        List<List<Integer>> resultList = Lists.newArrayList();
        if (targetList == null || targetList.size() == 0 || targetList.size() == 1) {
            return Arrays.asList(targetList);
        }
        for (int index = 0; index < targetList.size(); index++) {
            targetList = (List<Integer>) sourceList.clone();
            List<List<Integer>> ofList = of((ArrayList) dropInteger(targetList, index));
            for (List<Integer> tempList : ofList) {
                List<Integer> list = Lists.newArrayList();
                list.add(sourceList.get(index));
                list.addAll(tempList);
                resultList.add(list);
            }
        }
        return resultList;
    }

    private static List<Integer> dropInteger(List<Integer> integerList, int index) {
        integerList.remove(index);
        return integerList;
    }

}
