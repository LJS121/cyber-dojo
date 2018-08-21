package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to generate all potential
 * anagrams of an input string.
 * <p>
 * For example, the potential anagrams of "biro" are
 * <p>
 * biro bior brio broi boir bori
 * ibro ibor irbo irob iobr iorb
 * rbio rboi ribo riob roib robi
 * obir obri oibr oirb orbi orib
 *
 * @author msh11535
 */
public class Anagrams {

    public static void main(String[] args) {
        String anagrams = "birlide";
        char[] charArray = anagrams.toCharArray();

        List<String> list = new ArrayList<String>();
        list = combine(list, charArray, 0, charArray.length);
        System.err.println(JSONObject.toJSONString(list));

    }

    // b i r o
    private static List<String> combine(List<String> list, char[] arrays, int start, int length) {
        if (length == 0) {
            list.add(String.valueOf(arrays));
            return list;
        }

        for (int i = start; i < start + length; i++) {
            swap(arrays, start, i);
            list = combine(list, arrays, start + 1, length - 1);
            swap(arrays, start, i);//切记一定要换回，否则影响下次的循环交换。
        }


        return list;
    }

    private static void swap(char[] arrays, int start, int i) {
        char temp = arrays[start];
        arrays[start] = arrays[i];
        arrays[i] = temp;
    }

    public static int findCount(int num) {
        int result = 1;
        int i = 1;
        while (i < num) {
            result *= i++;
        }
        return result;
    }


}
