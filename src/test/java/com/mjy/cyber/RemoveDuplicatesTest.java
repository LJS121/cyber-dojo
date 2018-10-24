package com.mjy.cyber;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class RemoveDuplicatesTest {

    @Test
    public void removeDuplicates() {
        // given
        List list = Arrays.asList(1, 2);

        // when
        List toList = RemoveDuplicates.removeDuplicates(list);

        // then
        Assert.assertTrue(toList.containsAll(Arrays.asList(1, 2)));
    }

    @Test
    public void removeDuplicates_2() {
        // given
        List list = Arrays.asList();

        // when
        List toList = RemoveDuplicates.removeDuplicates(list);

        // then
        Assert.assertTrue(toList.containsAll(Arrays.asList()));
    }

    @Test
    public void removeDuplicates_3() {
        // given
        List list = Arrays.asList(1, 1, 2, 2, 3, 3);

        // when
        List toList = RemoveDuplicates.removeDuplicates(list);

        // then
        Assert.assertTrue(toList.containsAll(Arrays.asList(1, 2, 3)));
    }

}
