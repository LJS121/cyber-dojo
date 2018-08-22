package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ClosestToZeroTest {

    @Test
    public void closestToZero() {
        //given
        ClosestToZero closestToZero = new ClosestToZero();
        List<Integer> integerList = Arrays.asList(6, 9, 15, -2, 2, 92, 11);
        //when
        int closest = closestToZero.findClosestToZero(integerList);

        //then
        Assert.assertEquals(2, closest);

    }

}
