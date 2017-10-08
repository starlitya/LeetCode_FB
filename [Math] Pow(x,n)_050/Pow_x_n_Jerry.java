package com.example.starlitya.onlineassement.leetcode;


/*
Implement pow(x, n).
 */

public class Pow_x_n_Jerry {
    public double myPow(double x, int n) {
        if (x ==0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        int originalN = n;

        /* x^n = x^2^n/2 * x^2^n/2 */
        double result = 1.0;
        while (n != 0) {
            // notice negative one
            if (n % 2 != 0) {
                result = result * x;
            }
            x = x * x;
            n = n /2;
        }

        return (originalN > 0) ? result: 1/result;
    }

    public double myPow_old(double x, int n) {
        if (x ==0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        double result = 1.0;
        if (n > 0) {
            while(n-- > 0) {
                result *= x;
            }
        } else {
            while(n++ < 0) {
                result *= 1/x;
            }
        }
        return result;
    }
}