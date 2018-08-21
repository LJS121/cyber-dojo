package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

public class ArrayShuffleTest {

    @Test
    public void main() {
    }

    @Test
    public void swapList() {
    }

    @Test
    public void randomIndex() {
        Set<Integer> set = Sets.newHashSet();
        for (int i = 0; i < 10000; i++) {
            set.add(ArrayShuffle.randomIndex(1, 10));
        }
        System.err.println(JSONObject.toJSONString(set));
    }

    @Test
    public void createSortList() {
    }
}