package com.example.starlitya.onlineassement.practice;

import java.util.HashMap;
import java.util.Map;


/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

 */
public class Subarray_Sum_Equals_K_Jerry {

    public int subarraySum(int[] nums, int k) {
        // (sum-k , k ) = sum
        Map<Integer, Integer> preSum = new HashMap<>();
        // default one possible
        preSum.put(0 , 1);

        int count = 0;
        int sum = 0;
        for (int i=0; i< nums.length; i++) {
            sum += nums[i];
            if(preSum.containsKey(sum - k)) {
                count += preSum.get(sum -k);
            }

            // store current sum
            if (preSum.containsKey(sum)) {
                preSum.put(sum, preSum.get(sum) + 1);
            } else {
                preSum.put(sum, 1);
            }
        }
        return count;
    }

    public int subarraySum_old(int[] nums, int k) {
        int count = 0;
        for (int i=0; i< nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                count++;
            }

            int j = i+1;
            while (j < nums.length) {
                sum += nums[j++];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}