package com.example.starlitya.onlineassement.leetcode;


/*
Implement int sqrt(int x).

Compute and return the square root of x.
 */

public class Sqrt_X_Jerry {
    /* a^2 <= x < (a+1)^2 */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1;
        int right = Integer.MAX_VALUE;
        while(true) {
            int midA = left + (right-left)/2;
            if (midA > x/midA) { //too big
                right = midA-1;
            } else {
                if ((midA +1) > x/(midA+1)) {
                    return midA;
                }
                left = midA+1;
            }
        }
    }
}