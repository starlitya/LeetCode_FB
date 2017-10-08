package com.example.starlitya.onlineassement.leetcode;


import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */
public class Subset_Jerry {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        combine(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void combine(int[] data, int start, List<Integer> curr, List<List<Integer>> resultList) {
        // store
        resultList.add(new ArrayList<Integer>(curr));

        for(int i=start; i<data.length; i++) {
            curr.add(data[i]);
            combine(data, i+1, curr, resultList);
            curr.remove(curr.size()-1);
        }
    }

}