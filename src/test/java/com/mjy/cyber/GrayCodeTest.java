package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GrayCodeTest {

    @Test
    public void encodeGrayCode() {
        //given
        int[] b = new int[]{0, 1, 0, 0, 1, 0};
        int[] g = new int[]{1, 1, 0, 1, 1};

        //when
        int[] grayCode = GrayCode.encodeGrayCode(b);

        //then
        System.err.println(JSONObject.toJSONString(grayCode));
        Assert.assertTrue(Arrays.equals(g, grayCode));

    }

    @Test
    public void decodeGrayCode() {
        //given
        int[] b = new int[]{0, 1, 0, 0, 1, 0};
        int[] g = new int[]{1, 1, 0, 1, 1};

        //when

        //then
        int[] binary = GrayCode.decodeGrayCode(g);

        //then
        System.err.println(JSONObject.toJSONString(binary));
        Assert.assertTrue(Arrays.equals(b, binary));

    }

}
