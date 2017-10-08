package com.example.starlitya.onlineassement.practice;

import java.util.Arrays;


/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
target. Return the sum of the three integers.
You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Threee_Sum_Closet {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("incorrect params");
        }

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];
        for (int i=0; i< nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int newSum = nums[left] + nums[right] + nums[i];
                if(Math.abs(target - newSum) < Math.abs(target - result)) {
                    result = newSum;
                    if (result == target) {
                        return result;
                    }
                }

                if(newSum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}