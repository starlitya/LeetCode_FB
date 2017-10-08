package com.example.starlitya.onlineassement.leetcode;


/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB

 */

public class Excel_Sheet_Column_Title_Jerry {
    
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n !=0) {
            char target = (char)('A' + (n - 1) % 26);
            sb.append(target);

            n = (n -1) / 26;
        }

        return sb.reverse().toString();
    }

    public String convertToTitle_old(int n) {
        StringBuilder sb = new StringBuilder();
        while (n !=0) {
            int target = n % 26;
            sb.append(convertToChar(target));

            n = (n -1) / 26;
        }

        return sb.reverse().toString();
    }

    private char convertToChar(int target) {
        if (target == 0) {
            return 'Z';
        } else {
            int base = 'A';
            return (char)(target + base -1);
        }
    }
}