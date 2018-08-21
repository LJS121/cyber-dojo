package com.mjy.cyber;

import org.junit.Test;

public class AnagramsTest {


    @Test
    public void findCount() {

        for (int i = 1; i < 10; i++) {
            System.err.println(Anagrams.findCount(i));
        }

    }
}
