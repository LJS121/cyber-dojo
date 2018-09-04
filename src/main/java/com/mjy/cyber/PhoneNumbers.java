package com.mjy.cyber;

import java.util.List;

import com.google.common.collect.Lists;
import com.mjy.cyber.util.StringUtil;

public class PhoneNumbers {

    private static List<String> phoneNumberList;

    public static boolean checkPhoneNumberConsistent(List<String> list) {

        phoneNumberList = initPhoneNumberList(list);

        return checkIfExists();
    }

    private static boolean checkIfExists() {

        for (int i = 0; i < phoneNumberList.size(); i++) {
            String phoneNumber = phoneNumberList.get(i);
            for (int j = 0; j < phoneNumberList.size(); j++) {
                if (i != j && phoneNumber.startsWith(phoneNumberList.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<String> initPhoneNumberList(List<String> list) {

        phoneNumberList = Lists.newArrayList();
        for (String str : list) {
            String[] split = str.split(" ");
            split[0] = "";
            phoneNumberList.add(StringUtil.splicing(split));
        }
        return phoneNumberList;
    }

}
