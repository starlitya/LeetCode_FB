/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // DFS, better performance
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }
    
    private void helper(TreeNode rootNode, List<List<Integer>> result, int height) {
        if (rootNode == null) return;
        
        if (height >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        
        result.get(height).add(rootNode.val);
        
        helper(rootNode.left, result, height+1);
        helper(rootNode.right, result, height+1);
    }
    
    // BFS
    public List<List<Integer>> levelOrder_BFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        queue.offer(root);
        
        List<Integer> current = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current.add(node.val);
            
            if (node.left != null) {
                nextQueue.offer(node.left);
            }
            
            if (node.right != null) {
                nextQueue.offer(node.right);
            }
            
            if (queue.isEmpty()) {
                result.add(current);
                queue = nextQueue;
                current = new ArrayList<>();
                nextQueue = new LinkedList<>();
            }
        }
        
        return result;
    }
}