package com.example.starlitya.onlineassement.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.


 */
public class Letter_Combinations_of_a_Phone_Number_Jerry {

    private static final String [] TABLE = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<String>();
        combine(digits, 0, new StringBuilder(), result);
        return result;
    }

    //Time complexity O(3^n), Space complexityO(n).
    private void combine(String src, int startIndex, StringBuilder prefix, List<String> resultList) {
        if (startIndex >= src.length()) {
            resultList.add(prefix.toString());
            return;
        }

        String current = TABLE[src.charAt(startIndex)-'0'];
        for (int i=0; i<current.length(); i++) {
            prefix.append(current.charAt(i));
            combine(src, startIndex+1, prefix, resultList);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }


}