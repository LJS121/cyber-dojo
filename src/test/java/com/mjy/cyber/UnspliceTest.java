package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

public class UnspliceTest {

    @Test
    public void unsplice_1() {
        // given
        String str = "ab\\\ncd\\\nef";

        // when
        String result = Unsplice.of(str);

        // then
        Assert.assertEquals("\"abcdef\" (2 stripped out)", result);
    }

    @Test
    public void unsplice_2() {
        // given
        String str = "abc\\\ndef";

        // when
        String result = Unsplice.of(str);

        // then
        Assert.assertEquals("\"abcdef\" (1 stripped out)", result);
    }

    @Test
    public void unsplice_3() {
        // given
        String str = "abc\n\\def";

        // when
        String result = Unsplice.of(str);

        // then
        Assert.assertEquals("unchanged (wrong order)", result);
    }

}
