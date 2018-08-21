package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.List;

import static java.util.Collections.swap;

/**
 * Write a program to shuffle an array.
 * <p>
 * Start by writing a function which will accept two
 * integer arguments (min,max) and generate a random
 * integer between min and max where:
 * o) min is an inclusive lower bound
 * o) max is an exclusive upper bound
 * For example (1,7) should generate random integers
 * from {1,2,3,4,5,6} suitable for a dice roll.
 * How will you test this?
 * <p>
 * Use this function to write shuffle:
 * Iterate through the array and for each element[i]
 * generate a random integer (min=r,max=array.size)
 * swap the integers at indexes i and r
 * <p>
 * The shuffle function
 * o) does not mutate the array argument
 * o) returns an array
 * o) the returned array is randomly shuffled!
 * o) the returned array is a permutation of the array argument
 *
 * @author msh11535
 */
public class ArrayShuffle {


    public static void main(String[] args) {
        int min = 1;
        int max = 7;
        List<Integer> sortList = createSortList(min, max);

        int m = randomIndex(min, max) - 1;
        int n = randomIndex(min, max) - 1;


        System.err.println(JSONObject.toJSONString(sortList));

        System.err.println(JSONObject.toJSONString(swapList(sortList, m, n)));

    }

    public static List<Integer> swapList(List<Integer> sortList, int m, int n) {
        final List<Integer> newList = Lists.newArrayList();
        sortList.stream().forEach(integer -> newList.add(integer));
        swap(newList, m, n);
        return newList;
    }

    public static int randomIndex(int min, int max) {
        return (int) (1 + Math.random() * (max - min));
    }

    public static List<Integer> createSortList(int min, int max) {
        List<Integer> list = Lists.newArrayList();
        for (int i = min; i < max; i++) {
            list.add(i);
        }
        return list;
    }


}
