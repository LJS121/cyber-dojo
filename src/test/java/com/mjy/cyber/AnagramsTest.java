package com.mjy.cyber;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnagramsTest {


    @Test
    public void findCount() {
        //given
        Anagrams anagrams = new Anagrams();
        String anagramString = "biro";
        char[] charArray = anagramString.toCharArray();

        //when
        List<String> stringList = anagrams.combine(Lists.newArrayList(), charArray, 0, charArray.length);

        //then
        Assert.assertEquals(24, stringList.size());
        Assert.assertTrue(stringList.contains("bori"));
        Assert.assertTrue(stringList.contains("iorb"));
        Assert.assertTrue(stringList.contains("riob"));
        Assert.assertTrue(stringList.contains("oibr"));

    }
}
