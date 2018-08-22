package com.mjy.cyber;

import org.junit.Test;

public class CountCoinsTest {

    @Test
    public void exchangeCoins_15(){
        //given
        CountCoins countCoins = new CountCoins();
        countCoins.setFinalCents(15);

        //when
        countCoins.exchangeCoins(countCoins.getFinalCents());

        //then

    }

    @Test
    public void exchangeCoins_20(){
        //given
        CountCoins countCoins = new CountCoins();
        countCoins.setFinalCents(20);

        //when
        countCoins.exchangeCoins(countCoins.getFinalCents());

        //then

    }

}
