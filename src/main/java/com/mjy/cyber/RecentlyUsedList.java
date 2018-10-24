package com.mjy.cyber;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import junit.framework.Assert;

public class RecentlyUsedList {

    private static List<String> list = Lists.newLinkedList();
    private static Integer limit;

    public static void add(String item) {
        Assert.assertTrue(item != null && !"".equals(item));

        if (list.contains(item)) {
            list.remove(item);
        }
        list.add(item);
        validateLimit();
    }

    private static void validateLimit() {
        if (limit != null && list.size() > limit) {
            list.remove(0);
        }
    }

    public static void printList() {
        System.err.println(JSONObject.toJSONString(list));
    }

    public static List<String> findList() {
        return list;
    }

    public static void setLimit(Integer setLimit) {
        limit = setLimit;
    }

    public static String findNext() {
        if (list.size() != 0) {
            return list.get(list.size() - 1);
        } else {
            return null;
        }
    }

    public static String pull() {
        String item = list.get(list.size() - 1);
        list.remove(item);
        return item;
    }

}
