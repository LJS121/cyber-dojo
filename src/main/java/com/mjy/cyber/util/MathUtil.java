package com.mjy.cyber.util;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.util.Map;

public class MathUtil {

    public static int randomInt(int upper) {
        return Double.valueOf(Math.random() * upper).intValue();
    }

    public static int randomInt(int lowwer, int upper) {
        return randomInt(upper - lowwer) + lowwer;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < 10000; i++) {
            int rand = randomInt(1, 4);
            map.put(rand, map.get(rand) == null ? 1 : map.get(rand) + 1);
        }
        System.err.println(JSONObject.toJSONString(map));

        map = Maps.newHashMap();
        for (int i = 0; i < 10000; i++) {
            int rand = randomInt(3);
            map.put(rand, map.get(rand) == null ? 1 : map.get(rand) + 1);
        }
        System.err.println(JSONObject.toJSONString(map));

        map = Maps.newHashMap();
        for (int i = 0; i < 10000; i++) {
            int rand = randomInt(2);
            map.put(rand, map.get(rand) == null ? 1 : map.get(rand) + 1);
        }
        System.err.println(JSONObject.toJSONString(map));
    }

}
