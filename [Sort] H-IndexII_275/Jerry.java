class Solution {
    
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length-1;
        while(left <= right) {
            int mid = (left+right) >> 1;
            if (citations[mid] == (citations.length-mid)) {
                return citations[mid];
            } else if (citations[mid] > (citations.length-mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return citations.length - left;
    }
    
    public int hIndex_old(int[] citations) {
        int hidx = 0;
        for (int i=0; i< citations.length; i++) {
            if (citations[i] >= (citations.length - i)) {
                return citations.length - i;
            }
        }
        return hidx;
    }
}