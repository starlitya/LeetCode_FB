class Solution {
    
    public int removeDuplicates(int[] nums) {
        int i=0;
        for (int n: nums) {
            if (i < 2 || n != nums[i-2]) {
              nums[i++] = n;  
            }
        }
        return i;         
    }
    
    public int removeDuplicates_old(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result [] = new int[nums.length];
        result[0] = nums[0];
        
        int cont = 1;
        int len = 1;
        for (int i=1; i< nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                cont++;
                if (cont <= 2) {
                    result[len++] = nums[i];
                }
            } else {
                cont = 1;
                result[len++] = nums[i];
            }
        }
        
        for (int i=0; i < result.length; i++) {
            nums[i] = result[i];
        }
        
        return len;        
    }
}