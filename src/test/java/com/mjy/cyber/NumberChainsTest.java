package com.mjy.cyber;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NumberChainsTest {

    @Test
    public void numberChains() {

        //given
        int number = 123456789;
        //when
        List<Integer> numberChainList = NumberChains.getNumberChains(number);

        //when
        Assert.assertEquals(2, numberChainList.size());
        Assert.assertEquals(864197532, numberChainList.get(numberChainList.size() - 1).intValue());

    }

    @Test
    public void numberChains_2() {

        //given
        int number = 1234;
        //when
        List<Integer> numberChainList = NumberChains.getNumberChains(number);

        //when
        Assert.assertEquals(4, numberChainList.size());
        Assert.assertEquals(6174, numberChainList.get(numberChainList.size() - 1).intValue());

    }
    @Test
    public void numberChains_3() {

        //given
        int number = 444;
        //when
        List<Integer> numberChainList = NumberChains.getNumberChains(number);

        //when
        Assert.assertEquals(2, numberChainList.size());
        Assert.assertEquals(0, numberChainList.get(numberChainList.size() - 1).intValue());

    }

}
