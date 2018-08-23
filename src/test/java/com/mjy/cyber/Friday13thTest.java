package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class Friday13thTest {


    @Test
    public void Firday13th() throws Exception {
        //given
        Friday13th friday13th = new Friday13th();

        //when
        Map<Friday13th.Week, Integer> map = friday13th.findAll13th();

        //then
        System.err.println(JSONObject.toJSONString(map));
        Assert.assertTrue(map.get(Friday13th.Week.Friday) >= map.get(Friday13th.Week.Monday));
        Assert.assertTrue(map.get(Friday13th.Week.Friday) >= map.get(Friday13th.Week.Tuesday));
        Assert.assertTrue(map.get(Friday13th.Week.Friday) >= map.get(Friday13th.Week.Wednesday));
        Assert.assertTrue(map.get(Friday13th.Week.Friday) >= map.get(Friday13th.Week.Thursday));
        Assert.assertTrue(map.get(Friday13th.Week.Friday) >= map.get(Friday13th.Week.Saturday));
        Assert.assertTrue(map.get(Friday13th.Week.Friday) >= map.get(Friday13th.Week.Sunday));

    }

}
