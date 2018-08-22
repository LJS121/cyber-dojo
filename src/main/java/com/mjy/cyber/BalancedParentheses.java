package com.mjy.cyber;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Write a program to determine if the the parentheses (),
 * the brackets [], and the braces {}, in a string are balanced.
 * <p>
 * For example:
 * <p>
 * {{)(}} is not balanced because ) comes before (
 * <p>
 * ({)} is not balanced because ) is not balanced between {}
 * and similarly the { is not balanced between ()
 * <p>
 * [({})] is balanced
 * <p>
 * {}([]) is balanced
 * <p>
 * {()}[[{}]] is balanced
 *
 * @author msh11535
 */
public class BalancedParentheses {

    public static void main(String[] args) {
        List<String> list = initStringList();

        for (String str : list) {
            balanceCheck(str);
        }

    }

    private static List<String> initStringList() {
        return Lists.asList(")(){}", new String[]{
                    "{{[)(}}",
                    "({)}",
                    "[({})]",
                    "{}([])",
                    "{()}[[{}]]"});
    }

    private static void balanceCheck(String str) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (stack.isEmpty() && (charArray[i] == ')' || charArray[i] == ']' || charArray[i] == '}')) {
                System.out.println(str + "**** 不成对");
                return;
            } else if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                stack.push(charArray[i]);
            } else if (charArray[i] == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                }
            } else if (charArray[i] == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                }
            } else if (charArray[i] == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            System.out.println(str + "**** 成对");
        } else {
            System.out.println(str + "**** 不成对");
        }
    }

    private static boolean balance(String str) {
        if (str.contains("[") || str.contains("]")) {
            String regex = "(.*?)\\[(.*?)\\](.*?)";
            if (Pattern.compile(regex).matcher(str).matches() == false) {
//                System.err.println(str + " is not balance");
                return false;
            }
        }
        if (str.contains("(") || str.contains(")")) {
            String regex = "(.*?)\\((.*?)\\)(.*?)";
            if (Pattern.compile(regex).matcher(str).matches() == false) {
//                System.err.println(str + " is not balance");
                return false;
            }
        }
        if (str.contains("{") || str.contains("}")) {
            String regex = "(.*?)\\{(.*?)\\}(.*?)";
            if (Pattern.compile(regex).matcher(str).matches() == false) {
//                System.err.println(str + " is not balance.");
                return false;
            }
        }

//        if (str.contains("[")) {
//            int lastPerIndex = str.lastIndexOf("[");
//            int firstSufIndex = str.indexOf("]");
//            String tempStr = str.substring(lastPerIndex, firstSufIndex + 1);
//            if (balance(tempStr) == false) {
//                return false;
//            }
//        }


        System.err.println(str + " is balance.");
        return true;
    }

}
