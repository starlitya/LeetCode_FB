package com.example.starlitya.onlineassement.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */
public class Permutations_Jerry {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        combine(nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void combine(int []data, List<Integer> curr, List<List<Integer>> result) {
        if (data.length == curr.size()) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int i=0; i<data.length; i++) {
            if (!curr.contains(data[i])) {
                curr.add(data[i]);
                combine(data, curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }
}