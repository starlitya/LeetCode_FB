package com.example.starlitya.onlineassement.practice;


/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 */
public class Move_zeros_Jerry {

    public void moveZeroes(int[] nums) {
        int zeroStartIndex=-1;

        // find non-zero index
        for (int i=0; i< nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroStartIndex != -1) {
                    nums[zeroStartIndex] = nums[i];
                    nums[i] = 0;
                    zeroStartIndex++;
                }
            } else {
                // zero sequence start
                if (zeroStartIndex == -1) {
                    zeroStartIndex = i;
                }
            }
        }
    }

    public void moveZeroes_old2(int[] nums) {
        int zeroStartIndex=-1;
        int maxZeroLength = 0;

        // find non-zero index
        for (int i=0; i< nums.length; i++) {
            if (nums[i] != 0) {
                if (maxZeroLength != 0) {
                    nums[zeroStartIndex] = nums[i];
                    nums[i] = 0;
                    zeroStartIndex = i-maxZeroLength+1;
                }
            } else {
                // zero sequence start
                if (maxZeroLength == 0) {
                    zeroStartIndex = i;
                }
                maxZeroLength++;
            }
        }
    }

    public void moveZeroes_old(int[] nums) {
        for (int i=0; i < nums.length-1; i++) {
            boolean moved = false;
            for (int j=0; j < nums.length-1-i; j++) {
                if (nums[j] == 0) {
                    nums[j] = nums[j+1];
                    nums[j+1]=0;
                    moved = true;
                }
            }

            if(!moved) {
                return;
            }
        }
    }
}