package com.example.starlitya.onlineassement.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 */
public class Valid_Parentheses_Jerry {

    public boolean isValid(String testStr) {

        Stack<Character> dataPoll = new Stack<Character>();
        for (char c : testStr.toCharArray()) {
            if (c  == '(') {
                dataPoll.push(')');
            } else if (c  == '[') {
                dataPoll.push(']');
            } else if (c  == '{') {
                dataPoll.push('}');
            } else if (dataPoll.isEmpty()) {
                return false;
            } else {
                char cn = dataPoll.pop();
                if (cn != c) {
                    return false;
                }
            }
        }

        return dataPoll.isEmpty();
    }

}