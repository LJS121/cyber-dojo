package com.mjy.cyber;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Pattern;

public class BalancedParentheses {

    public static void main(String[] args) {
        List<String> list = Lists.asList("{{[)(}}", new String[]{
                "({)}",
                "[({})]",
                "{}([])",
                "{()}[[{}]]"});

        for (String str : list) {
            balance(str);
        }

    }

    private static boolean balance(String str) {
        if (str.contains("[") || str.contains("]")) {
            String regex = "(.*?)\\[(.*?)\\](.*?)";
            if (Pattern.compile(regex).matcher(str).matches() == false) {
                System.err.println(str + " is not balance");
                return false;
            }
        }
        if (str.contains("(") || str.contains(")")) {
            String regex = "(.*?)\\((.*?)\\)(.*?)";
            if (Pattern.compile(regex).matcher(str).matches() == false) {
                System.err.println(str + " is not balance");
                return false;
            }
        }
        if (str.contains("{") || str.contains("}")) {
            String regex = "(.*?)\\{(.*?)\\}(.*?)";
            if (Pattern.compile(regex).matcher(str).matches() == false) {
                System.err.println(str + " is not balance.");
                return false;
            }
        }
        System.err.println(str + " is balance.");
        return true;
    }

}
