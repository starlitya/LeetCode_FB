package com.example.starlitya.onlineassement.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

 */
public class Roman_to_Integer_Jerry {

    public int romanToInt(String s) {
        if (s == null || s.length() ==0) {
            return 0;
        }

        Map<Character, Integer> table = new HashMap<>();
        table.put('M', 1000);
        table.put('D', 500);
        table.put('C', 100);
        table.put('L', 50);
        table.put('X', 10);
        table.put('V', 5);
        table.put('I', 1);

        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            int current = table.get(s.charAt(i));
            sum += current;
            if (i != 0) {
                int last = table.get(s.charAt(i-1));
                if (current > last) {
                    sum -= last*2;
                }
            }
        }
        return sum;
    }

}