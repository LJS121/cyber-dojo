package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

public class ISBNTest {

    @Test
    public void checkISBN_10(){
        //given
        String code = "0 471 48648 5";

        //when
        boolean ifAccord = ISBN.checkISBN(code);

        //then
        Assert.assertTrue(ifAccord);

    }

    @Test
    public void checkISBN_13(){
        //given
        String code = "978-0 471 48657 8";

        //when
        boolean ifAccord = ISBN.checkISBN(code);

        //then
        Assert.assertTrue(ifAccord);

    }


}
