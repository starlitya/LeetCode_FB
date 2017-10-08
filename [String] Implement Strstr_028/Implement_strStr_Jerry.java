package com.example.starlitya.onlineassement.leetcode;


/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 */
public class Implement_strStr_Jerry {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        for (int i=0; i<=haystack.length()-needle.length(); i++) {
            for (int j=0; j<=needle.length(); j++) {
                if (j == needle.length()) {
                    return i;
                }

                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
        }

        return -1;
    }
}