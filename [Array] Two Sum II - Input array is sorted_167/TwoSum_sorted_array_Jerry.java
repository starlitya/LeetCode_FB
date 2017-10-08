package com.example.starlitya.onlineassement.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
Given an array of integers that is already sorted in ascending order,
find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

 */
public class TwoSum_sorted_array_Jerry {

    public int[] twoSum(int[] data, int target) {
        int left = 0;
        int right = data.length-1;

        while(left < right) {
            int sum = data[left] + data[right];
            if (sum == target) {
                return new int[] {left+1, right+1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public int[] twoSum_old(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i< numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int value = map.get(numbers[i]);
                return new int[] {value, i+1};
            }
            map.put(target-numbers[i], i+1);
            System.out.println("put "+ (target-numbers[i]) + " , " + (i+1));
        }

        return null;
    }
}