package com.mjy.cyber;

import com.google.common.collect.Lists;

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

}
