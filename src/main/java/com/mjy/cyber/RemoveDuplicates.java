package com.mjy.cyber;

import java.util.List;

import com.google.common.collect.Lists;

public class RemoveDuplicates {

    public static List removeDuplicates(List list) {
        if (list != null && list.size() > 0) {

            List toList = Lists.newArrayList();
            for (Object obj : list) {
                if (!toList.contains(obj)) {
                    toList.add(obj);
                }
            }
            return toList;
        } else {
            return list;
        }
    }

}
