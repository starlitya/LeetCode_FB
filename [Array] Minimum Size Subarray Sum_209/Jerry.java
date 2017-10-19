class Solution {
    
    // O(N LogN)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //sums of (0, i-1)
        int []sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i=1; i<=nums.length; i++) {
            sum[i] = sum[i-1]+nums[i-1];
        }

        int minLen = nums.length+1;
        for (int j=0; j < nums.length; j++) {
            int end = binarySearchEnd(j+1, nums.length, sum[j] + s, sum);
            if (end == nums.length+1) {
                break;
            }
            minLen = Math.min(minLen, end-j);
        }

        return minLen > nums.length ? 0: minLen;
    }

    private int binarySearchEnd(int left, int right, int key, int []sums) {
        while (left <= right) {
            int mid = (left+right) / 2;
            if (sums[mid] >= key) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
    
    // O(N)
    public int minSubArrayLen_old(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int minLen = nums.length+1;
        int sum = 0;
        while(left <= right && right <= nums.length) {
            if (sum >= s) {
                minLen = Math.min(minLen, right-left);
                sum -= nums[left];
                left++;
            } else {
                if (right < nums.length) {
                    sum += nums[right];
                }
                right++;
            }
        }

        return minLen > nums.length ? 0: minLen;
    }
}