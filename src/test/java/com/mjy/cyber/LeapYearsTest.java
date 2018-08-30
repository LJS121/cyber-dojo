package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

public class LeapYearsTest {

    @Test
    public void checkLeapYears(){
        //given
        int year = 2008;
        //when
        boolean isLeapYears = LeapYears.checkLeapYears(year);

        //then
        Assert.assertTrue(isLeapYears);
    }

    @Test
    public void checkLeapYears_2000(){
        //given
        int year = 2000;
        //when
        boolean isLeapYears = LeapYears.checkLeapYears(year);

        //then
        Assert.assertTrue(isLeapYears);
    }

    @Test
    public void checkLeapYears_2010(){
        //given
        int year = 2010;
        //when
        boolean isLeapYears = LeapYears.checkLeapYears(year);

        //then
        Assert.assertTrue(!isLeapYears);
    }

    @Test
    public void checkLeapYears_2001(){
        //given
        int year = 2001;
        //when
        boolean isLeapYears = LeapYears.checkLeapYears(year);

        //then
        Assert.assertTrue(!isLeapYears);
    }


}
