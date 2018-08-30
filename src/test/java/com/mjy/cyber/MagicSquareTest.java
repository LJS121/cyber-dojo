package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MagicSquareTest {

    @Test
    public void findMagicNumber() {
        //given
        List<Double> givenList = Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0);

        //when
        Double magicNum = MagicSquare.findMagicNumber(givenList);

        //then
        Assert.assertEquals(9, magicNum.intValue());
    }

    @Test
    public void findMagicNumber_2() {
        //given
        List<Double> givenList = Arrays.asList(1.0, 1.2, 1.4, 1.6, 1.8, 2.0, 2.2, 2.4, 2.6);

        //when
        Double magicNum = MagicSquare.findMagicNumber(givenList);

        //then
        Assert.assertNotNull(magicNum);
        Assert.assertEquals(54, Double.valueOf(magicNum * 10).intValue());
    }

}
