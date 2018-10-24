package com.mjy.cyber.recursive;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.mjy.cyber.util.MathUtil;

public class RecursiveTaskTest {

    @Test
    public void test() {
        // given
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 1000000; i++) {
            list.add(MathUtil.randomInt(1000));
        }

        // when
        int result = CalculateTask.calc(list);

        // then
        AtomicInteger sum = new AtomicInteger();
        list.forEach(num -> sum.set(sum.get() + num));
        System.err.println("sum = " + sum);
        Assert.assertEquals(sum.get(), result);
    }

    @Test
    public void test2() {
        for (int time = 0; time < 100; time++) {
            test();
        }
    }

}
