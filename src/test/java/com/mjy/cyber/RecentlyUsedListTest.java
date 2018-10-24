package com.mjy.cyber;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.AssertionFailedError;

public class RecentlyUsedListTest {

    @Test
    public void 添加一个元素() {
        // given
        String item = "testItem1";

        // when
        RecentlyUsedList.add(item);

        // then
        List<String> list = RecentlyUsedList.findList();
        Assert.assertTrue(list.contains(item));
        Assert.assertEquals(item, RecentlyUsedList.findNext());
    }

    @Test
    public void 设置集合大小() {
        // given
        int limit = 5;

        // when
        RecentlyUsedList.setLimit(limit);
        for (int i = 0; i < limit + 1; i++) {
            RecentlyUsedList.add("testItem" + i);
        }

        // then

        Assert.assertEquals(limit, RecentlyUsedList.findList().size());
    }

    @Test
    public void 添加已存在的数据() {
        // given
        String item = "testItem000";
        RecentlyUsedList.add(item);
        RecentlyUsedList.setLimit(null);
        for (int i = 0; i < 5; i++) {
            RecentlyUsedList.add("testItem" + i);
        }
        // when

        RecentlyUsedList.add(item);

        // then
        List<String> list = RecentlyUsedList.findList();
        Assert.assertEquals(item, RecentlyUsedList.findNext());
        Assert.assertFalse(list.get(0).equals(item));
        RecentlyUsedList.printList();
    }

    @Test(expected = AssertionFailedError.class)
    public void 添加空异常() {
        // given
        String item = "";
        // when
        RecentlyUsedList.add(item);
    }

    @Test
    public void pull() {
        // given
        String item = "";
        for (int i = 0; i < 5; i++) {
            RecentlyUsedList.add("testItem" + i);
        }

        // when
        while (RecentlyUsedList.findNext() != null) {
            System.err.println(RecentlyUsedList.pull());
        }
    }



}
