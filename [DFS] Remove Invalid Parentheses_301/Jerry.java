class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int removeL = 0, removeR=0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                removeL++;
            } else if(c == ')') {
                if (removeL != 0) {
                    removeL--;
                } else {
                    removeR++;
                }
            }
        }
        
        Set<String> ans = new HashSet<>();
        dfs(s, 0, ans, new StringBuilder(), removeL, removeR, 0);       
        return new ArrayList<String>(ans);
    }
    
    private void dfs(String s, int start, Set<String> ans, StringBuilder sb, int removeL, int removeR, int stack) {
        if (removeL <0 || removeR < 0 || stack < 0) {
            return;
        }
        
        if (start == s.length()) {
            if (removeL == 0 && removeR == 0 && stack == 0) {
                ans.add(sb.toString());
            }
            return;
        }
        
        char c = s.charAt(start);
        int len = sb.length();
        
        if (c == '(') {
            dfs(s, start+1, ans, sb, removeL-1, removeR, stack); // remove it
            dfs(s, start+1, ans, sb.append(c), removeL, removeR, stack+1);
        } else if (c == ')') {
            dfs(s, start+1, ans, sb, removeL, removeR-1, stack); // remove it
            dfs(s, start+1, ans, sb.append(c), removeL, removeR, stack-1);
        } else {
            dfs(s, start+1, ans, sb.append(c), removeL, removeR, stack);
        }
        
        sb.setLength(len);
    }
    
    
}