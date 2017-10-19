class Solution {
    
    // O(n)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int count[] = new int[citations.length+1];
        for (int i=0; i<citations.length; i++) {
            if (citations[i] >= citations.length) {
                count[citations.length]++;
            } else {
                count[citations[i]]++;
            }
        }
        
        int total = 0;
        for (int i=citations.length; i>=0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }
        
        return 0;
    }
    
    // O(nlogn)
    public int hIndex_old(int[] citations) {
        Arrays.sort(citations);
        
        int hidx = 0;
        for (int i=0; i< citations.length; i++) {
            if (citations[i] >= (citations.length - i)) {
                return citations.length - i;
            }
        }
        
        return hidx;
    }
}