package com.example.starlitya.onlineassement.leetcode;


/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class Multiply_Strings_Jerry {

    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int [] product = new int [n1+n2];

        for (int i=n1-1; i>=0; i--) {
            for (int j=n2-1; j>=0; j--) {
                //System.out.println("index " + i + " " + j);

                //n1-1-i => start from now i with 0
                int currentIndex = n1+n2-2-i-j;
                // better to currentIndex = i+j, reverse to real order
                int sum = char2digit(num1, i) * char2digit(num2, j) + product[currentIndex];

                int pos2 = sum % 10;
                int pos1 = sum / 10;
                product[currentIndex] = pos2;
                product[currentIndex+1] += pos1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=product.length-1; i>=0; i--) {
            // avoid leading zero
            if (product[i] != 0 || sb.length() != 0) {
                sb.append(product[i]);
            }
        }
        return (sb.length() != 0)? sb.toString() : "0";
    }

    private int char2digit(String number, int index) {
        return number.charAt(index) - '0';
    }


    public String multiply_old_fail(String num1, String num2) {
        StringBuilder reverseResult = new StringBuilder();
        int lastCarry[] = new int[num1.length() + num2.length()];

        int MAX= Math.max(num1.length(), num2.length());
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i= 0; i< MAX; i++) {
            int sum = lastCarry[i];
            for(int mult=0; mult<= i; mult++) {
                int index2 = i - mult;
                int index1 = mult;
                System.out.println("index " + index2 + " " + index1);
                if(index1 > num1.length()-1 || index2 > num2.length()-1) {
                    continue;
                }
                sum += char2digit(num2, index2)
                        *char2digit(num1, index1);

                if(sum > 9) {
                    lastCarry[i+1] += sum/10;
                }
            }

            reverseResult.append(sum % 10);
        }

        if (lastCarry[MAX] != 0) {
            reverseResult.append(lastCarry[MAX]);
        }

        System.out.println("resverse result " + reverseResult.toString());
        return reverseResult.reverse().toString();
    }

}