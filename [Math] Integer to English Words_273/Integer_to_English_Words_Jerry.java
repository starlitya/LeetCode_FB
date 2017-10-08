package com.example.starlitya.onlineassement.leetcode;


/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */

public class Integer_to_English_Words_Jerry {

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String result = "";
        for (int i=0; num > 0; i++) {
            if (num % 1000 != 0) {
                result = getCentiNumber(num % 1000) + THOUSANDS[i] + " " + result;
            }
            num = num / 1000;
        }

        return result.trim();
    }

    private String getCentiNumber(int target) {
        if (target >= 1000) {
            throw new IllegalArgumentException("incorrect centi format");
        }

        if (target == 0) {
            return "";
        } else if (target < 20) {
            return LESS_THAN_20[target] + " ";
        } else if (target < 100) {
            return TENS[target/10] + " " + getCentiNumber(target % 10);
        } else {
            return LESS_THAN_20[target/100] + " Hundred " + getCentiNumber(target % 100);
        }
    }

}