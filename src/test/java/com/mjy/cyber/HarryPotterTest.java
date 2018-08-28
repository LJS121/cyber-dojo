package com.mjy.cyber;
/**
 *金额单位 元*100
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HarryPotterTest {

    @Test
    public void 一本书() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(HarryPotterTitle.valueOf("HarryPotter1"));
        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(800, cost);
    }

    @Test
    public void 两本不同的书() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(HarryPotterTitle.valueOf("HarryPotter1"), HarryPotterTitle.valueOf("HarryPotter2"));

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(Double.valueOf(800 * bookList.size() * 0.95).intValue(), cost);
    }

    @Test
    public void 三本不同的书() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(HarryPotterTitle.valueOf("HarryPotter1"), HarryPotterTitle.valueOf("HarryPotter2"), HarryPotterTitle.valueOf("HarryPotter3"));

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(Double.valueOf(800 * bookList.size() * 0.9).intValue(), cost);
    }

    @Test
    public void 四本不同的书() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter2"),
                HarryPotterTitle.valueOf("HarryPotter3"),
                HarryPotterTitle.valueOf("HarryPotter4")
        );

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(Double.valueOf(800 * bookList.size() * 0.8).intValue(), cost);
    }

    @Test
    public void 五本不同的书() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter2"),
                HarryPotterTitle.valueOf("HarryPotter3"),
                HarryPotterTitle.valueOf("HarryPotter4"),
                HarryPotterTitle.valueOf("HarryPotter5")
        );

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(Double.valueOf(800 * bookList.size() * 0.75).intValue(), cost);
    }

    @Test
    public void 两本书_有两本重复() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(HarryPotterTitle.valueOf("HarryPotter1"), HarryPotterTitle.valueOf("HarryPotter1"));

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(Double.valueOf(800 * bookList.size()).intValue(), cost);
    }

    @Test
    public void 三本书_有两本重复() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter2")
        );

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(Double.valueOf(800 * 2 * 0.95).intValue() + 800, cost);
    }

    @Test
    public void 三本书_有三本重复() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter1")
        );

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(3 * 800, cost);
    }

    @Test
    public void 四本书_有两本重复() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter2"),
                HarryPotterTitle.valueOf("HarryPotter3")
        );

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(Double.valueOf(800 * 3 * 0.9).intValue() + 800, cost);
    }

    @Test
    public void 五本书_有两本重复() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(
                HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter2"),
                HarryPotterTitle.valueOf("HarryPotter3"),
                HarryPotterTitle.valueOf("HarryPotter4")
        );

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(Double.valueOf(800 * 4 * 0.8).intValue() + 800, cost);
    }

    @Test
    public void 六本书_有两本重复() {
        //given
        List<HarryPotterTitle> bookList = Arrays.asList(
                HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter1"),
                HarryPotterTitle.valueOf("HarryPotter2"),
                HarryPotterTitle.valueOf("HarryPotter3"),
                HarryPotterTitle.valueOf("HarryPotter4"),
                HarryPotterTitle.valueOf("HarryPotter5")
        );

        //when
        int cost = HarryPotter.calculateCost(bookList);

        //then
        Assert.assertEquals(Double.valueOf(800 * 5 * 0.75).intValue() + 800, cost);
    }

}
