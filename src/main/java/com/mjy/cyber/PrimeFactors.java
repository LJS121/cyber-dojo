package com.mjy.cyber;

import java.util.List;

import com.google.common.collect.Lists;

public class PrimeFactors {

    public static List<Integer> of(int num) {
        List<Integer> list = Lists.newArrayList();

        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                num = num / i;
                i = 2;
            }
        }

        return list;
    }
}
