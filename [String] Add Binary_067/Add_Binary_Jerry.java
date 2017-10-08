package com.example.starlitya.onlineassement.leetcode;

import java.util.HashMap;
import java.util.Map;


/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

 */
public class Add_Binary_Jerry {

    //TODO better solution that not used array to store
    public String addBinary(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int sumSize = n1 > n2 ? n1+1: n2+1;
        int [] sumArray = new int[sumSize];

        for (int i=sumSize-1; i>0; i--) {
            int indexA = n1+i-sumSize;
            int sum = sumArray[i];
            if (indexA >=0) {
                sum += a.charAt(indexA) - '0';
            }

            int indexB = n2+i-sumSize;
            if (indexB >=0) {
                sum += b.charAt(indexB) - '0';
            }

            sumArray[i] = sum%2;
            sumArray[i-1] += sum/2;
        }

        StringBuilder sb = new StringBuilder();
        for(int s: sumArray) {
            if (s != 0 || sb.length()!=0) {
                sb.append(s);
            }
        }
        return (sb.length() != 0) ? sb.toString(): "0";
    }
}