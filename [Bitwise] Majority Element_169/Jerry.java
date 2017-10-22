class Solution {
    
    // O(n), bitwise
    public int majorityElement(int[] nums) {
        int [] bitCount = new int[32];
        int result = 0;
        for (int i=0; i<32; i++) {
            int ones = 0, zeros = 0;
            for (int j=0; j<nums.length; j++) {
                if((nums[j] >> i & 1)==1) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            
            if (ones > zeros) {
                result |= 1 << i;
            }
        }
        return result;
    }
    
    // O(n), vote
    public int majorityElement_old(int[] nums) {
        int major = nums[0], count = 1;
        for (int i=1; i< nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
                if (count > nums.length/2) break;
            } else {
                count--;
            }
        }
        return major;
    }
    
    // O(nlogn)
    public int majorityElement_old2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}