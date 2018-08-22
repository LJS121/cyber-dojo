package com.mjy.cyber;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class HundredDoorsTest {

    @Test
    public void 最终开关状态符合预期() {
        //given
        //初始化门序列
        HundredDoors hundredDoors = new HundredDoors();
        hundredDoors.initDoors();

        //when
        //执行visit
        hundredDoors.visit();
        //打印门状态
//        hundredDoors.print();

        //then
        Assert.assertTrue(hundredDoors.getDoorList().get(0).isState());
        Assert.assertFalse(hundredDoors.getDoorList().get(1).isState());
        Assert.assertFalse(hundredDoors.getDoorList().get(2).isState());
        Assert.assertTrue(hundredDoors.getDoorList().get(3).isState());


    }

    @Test
    public void 最终开关状态不符合预期() {

        //given

        //when

        //then

    }

}
