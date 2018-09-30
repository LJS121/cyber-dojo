package com.mjy.cyber;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class PrimeFactorsTest {

    @Test
    public void number_2() {
        // given
        int num = 2;

        // when
        List<Integer> list = PrimeFactors.of(num);

        // then
        Assert.assertTrue(list.containsAll(Arrays.asList(2)));
    }

    @Test
    public void number_3() {
        // given
        int num = 3;

        // when
        List<Integer> list = PrimeFactors.of(num);

        // then
        Assert.assertTrue(list.containsAll(Arrays.asList(3)));
    }

    @Test
    public void number_4() {
        // given
        int num = 4;

        // when
        List<Integer> list = PrimeFactors.of(num);

        // then
        Assert.assertTrue(list.containsAll(Arrays.asList(2, 2)));
    }

    @Test
    public void number_5() {
        // given
        int num = 5;

        // when
        List<Integer> list = PrimeFactors.of(num);

        // then
        Assert.assertTrue(list.containsAll(Arrays.asList(5)));
    }

    @Test
    public void number_6() {
        // given
        int num = 6;

        // when
        List<Integer> list = PrimeFactors.of(num);
        System.err.println(JSONObject.toJSONString(list));

        // then
        Assert.assertTrue(list.containsAll(Arrays.asList(2, 3)));
    }

    @Test
    public void number_9() {
        // given
        int num = 9;

        // when
        List<Integer> list = PrimeFactors.of(num);
        System.err.println(JSONObject.toJSONString(list));

        // then
        Assert.assertTrue(list.containsAll(Arrays.asList(3, 3)));
    }

    @Test
    public void number_12() {
        // given
        int num = 12;

        // when
        List<Integer> list = PrimeFactors.of(num);

        // then
        Assert.assertTrue(list.containsAll(Arrays.asList(2, 2, 3)));
    }

    @Test
    public void number_15() {
        // given
        int num = 15;

        // when
        List<Integer> list = PrimeFactors.of(num);
        System.err.println(JSONObject.toJSONString(list));

        // then
        Assert.assertTrue(list.containsAll(Arrays.asList(3, 5)));
    }

}
