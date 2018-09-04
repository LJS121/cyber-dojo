package com.mjy.cyber;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class PhoneNumbersTest {

    @Test
    public void checkPhoneNumberConsistent() {

        //given
        List<String> list = Lists.newArrayList();
        list.add("Bob 91 12 54 26");
        list.add("Alice 97 625 992");
        list.add("Emergency 911");

        //when
        boolean ifConsistent = PhoneNumbers.checkPhoneNumberConsistent(list);

        //then
        Assert.assertTrue(!ifConsistent);

    }

    @Test
    public void checkPhoneNumberConsistent_2() {

        //given
        List<String> list = Lists.newArrayList();
        list.add("Bob 91 32 54 26");
        list.add("Alice 97 625 992");
        list.add("Emergency 911");

        //when
        boolean ifConsistent = PhoneNumbers.checkPhoneNumberConsistent(list);

        //then
        Assert.assertTrue(ifConsistent);

    }
    @Test
    public void checkPhoneNumberConsistent_3() {

        //given
        List<String> list = Lists.newArrayList();
        list.add("Bob 91 32 54 26");
        list.add("Bob 91 32 54 26 999");
        list.add("Alice 97 625 992");
        list.add("Emergency 911");

        //when
        boolean ifConsistent = PhoneNumbers.checkPhoneNumberConsistent(list);

        //then
        Assert.assertTrue(!ifConsistent);

    }

}
