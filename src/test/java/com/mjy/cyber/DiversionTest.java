package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

public class DiversionTest {

    @Test
    public void diversion_digit_3() {
        //given
        Diversion diversion = new Diversion();

        //when
        int diversionCount = diversion.diversion(3);

        //then
        Assert.assertEquals(5, diversionCount);

    }

    @Test
    public void diversion_digit_4() {
        //given
        Diversion diversion = new Diversion();

        //when
        int diversionCount = diversion.diversion(4);

        //then
        Assert.assertEquals(8, diversionCount);

    }

    @Test
    public void diversion_digit_5() {
        //given
        Diversion diversion = new Diversion();

        //when
        int diversionCount = diversion.diversion(5);

        //then
        Assert.assertEquals(13, diversionCount);

    }

    @Test
    public void diversion_digit_10() {
        //given
        Diversion diversion = new Diversion();

        //when
        int diversionCount = diversion.diversion(10);

        //then
        Assert.assertEquals(144, diversionCount);

    }

}
