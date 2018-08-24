package com.mjy.cyber;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

public class TestJsonProperty {

    @Test
    public void testJsonProperty() throws JsonProcessingException {
        //gieven
        Trade trade = new Trade();
        trade.setPayNo("testPayNo");
        trade.setOrderNo("testOrderNo");
        //when
        ObjectMapper objectMapper = new ObjectMapper();
        System.err.println(objectMapper.writeValueAsString(trade));

        //then

    }

    @Test
    public void testJsonProperty2() throws Exception {
        //gieven
        Trade trade = new Trade();
        trade.setPayNo("testPayNo");
        trade.setOrderNo("testOrderNo");
        //when
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(trade);
        System.err.println(jsonString);

        //when
        Trade tradeNew = objectMapper.readValue(jsonString, Trade.class);

        //then
        System.err.println(JSONObject.toJSONString(tradeNew));
    }

}


@Data
class Trade {
    @JsonProperty("支付宝交易号")
    private String payNo;

    @JsonProperty("商户订单号")
    private String orderNo;
}
