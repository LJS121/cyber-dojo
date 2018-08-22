package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CombinedNumberTest {

    @Test
    public void largest_possible_combined_number() {
        //given
        CombinedNumber combinedNumber = new CombinedNumber();
        List<Integer> integerList = Arrays.asList(50, 2, 1, 9);

        //when
        String largestNumber = combinedNumber.combineLargestNumber(integerList);

        //then
        Assert.assertEquals("95021", largestNumber);

    }

    @Test
    public void largest_possible_combined_number_whit_same_number() {
        //given
        CombinedNumber combinedNumber = new CombinedNumber();
        List<Integer> integerList = Arrays.asList(50, 2, 1, 9, 95, 957, 958);

        //when
        String largestNumber = combinedNumber.combineLargestNumber(integerList);

        //then
        Assert.assertEquals("9959589575021", largestNumber);

    }

    @Test
    public void largest_possible_combined_number_whit_same_number_twice() {
        //given
        CombinedNumber combinedNumber = new CombinedNumber();
        List<Integer> integerList = Arrays.asList(50, 2, 1, 9, 95, 957, 958, 958);

        //when
        String largestNumber = combinedNumber.combineLargestNumber(integerList);

        //then
        Assert.assertEquals("9959589589575021", largestNumber);

    }


}
