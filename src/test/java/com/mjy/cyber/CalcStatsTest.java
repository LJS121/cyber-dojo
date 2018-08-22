package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CalcStatsTest {

    @Test
    public void minimum_value() {
        //given
        CalcStats calcStats = new CalcStats();
        List<Integer> integerList = Arrays.asList(6, 9, 15, -2, 92, 11);

        //when
        int minimum_value = calcStats.minimumValue(integerList);

        //then
        Assert.assertEquals(-2, minimum_value);

    }

    @Test
    public void maximum_value() {
        //given
        CalcStats calcStats = new CalcStats();
        List<Integer> integerList = Arrays.asList(6, 9, 15, -2, 92, 11);

        //when
        int maximum_value = calcStats.maximumValue(integerList);

        //then
        Assert.assertEquals(92, maximum_value);

    }

    @Test
    public void number_of_elements_in_the_sequence() {
        //given
        CalcStats calcStats = new CalcStats();
        List<Integer> integerList = Arrays.asList(6, 9, 15, -2, 92, 11);

        //when
        int elementCount = calcStats.elementCount(integerList);

        //then
        Assert.assertEquals(6, elementCount);
    }

    @Test
    public void average_value() {
        //given
        CalcStats calcStats = new CalcStats();
        List<Integer> integerList = Arrays.asList(6, 9, 15, -2, 92, 11);

        //when
        BigDecimal averageValue = calcStats.averageValue(integerList);

        //then
        Assert.assertEquals(new BigDecimal("21.83"), averageValue);

    }


}
