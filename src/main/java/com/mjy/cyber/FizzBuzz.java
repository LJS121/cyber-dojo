package com.mjy.cyber;

public class FizzBuzz {

    public void printFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            System.err.println(fizzBuzzNum(i));
        }
    }

    private String fizzBuzzNum(int num) {
        String tempString = "";
        if (num % 3 == 0) {
            tempString += "Fizz";
        }
        if (num % 5 == 0) {
            tempString += "Buzz";
        }
        return "".equals(tempString) ? String.valueOf(num) : tempString;
    }

    public void printFizzBuzzPlus() {
        for (int i = 1; i <= 100; i++) {
            System.err.println(fizzBuzzPlusNum(i));
        }
    }

    private String fizzBuzzPlusNum(int num) {
        String tempString = "";
        if (num % 3 == 0 || String.valueOf(num).contains("3")) {
            tempString += "Fizz";
        }
        if (num % 5 == 0 || String.valueOf(num).contains("5")) {
            tempString += "Buzz";
        }
        return "".equals(tempString) ? String.valueOf(num) : tempString;
    }
}
