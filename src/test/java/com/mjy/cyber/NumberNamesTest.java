package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

public class NumberNamesTest {

    @Test
    public void getNumberName() {

        //given
        int number = 1;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("one", names);

    }

    @Test
    public void getNumberName_2() {

        //given
        int number = 99;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("ninety nine", names);

    }

    @Test
    public void getNumberName_3() {

        //given
        int number = 18;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("eighteen", names);

    }

    @Test
    public void getNumberName_4() {

        //given
        int number = 300;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("three hundred", names);

    }

    @Test
    public void getNumberName_5() {

        //given
        int number = 310;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("three hundred and ten", names);

    }

    @Test
    public void getNumberName_6() {

        //given
        int number = 1501;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("one thousand, five hundred and one", names);

    }

    @Test
    public void getNumberName_7() {

        //given
        int number = 12609;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("twelve thousand, six hundred and nine", names);

    }

    @Test
    public void getNumberName_8() {

        //given
        int number = 512607;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("five hundred and twelve thousand, six hundred and seven", names);

    }

    @Test
    public void getNumberName_9() {

        //given
        int number = 512000;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("five hundred and twelve thousand", names);

    }

    @Test
    public void getNumberName_10() {

        //given
        int number = 4112603;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("four million, one hundred and twelve thousand, six hundred and three", names);

    }
    @Test
    public void getNumberName_11() {

        //given
        int number = 43112603;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("fourty three million, one hundred and twelve thousand, six hundred and three", names);

    }
    @Test
    public void getNumberName_12() {

        //given
        int number = 243112603;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("two hundred and fourty three million, one hundred and twelve thousand, six hundred and three", names);

    }

    @Test
    public void getNumberName_13() {

        //given
        int number = 52609;

        //when
        String names = NumberNames.getNumberName(number);

        //then
        Assert.assertEquals("fifty two thousand, six hundred and nine", names);

    }

}
