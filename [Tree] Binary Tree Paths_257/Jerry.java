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
    
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            
            if (root == null) {
                return result;
            }
            
            if (root.left == null && root.right == null) {
                result.add(root.val + "");
                return result;
            }
            
            for (String path: binaryTreePaths(root.left)) {
                result.add(root.val + "->" + path);
            }
            
            for (String path: binaryTreePaths(root.right)) {
                result.add(root.val + "->" + path);
            }

            return result;
        }
      
        public List<String> binaryTreePaths_old(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            helper(root, new StringBuilder(), result);
            return result;
        }

        private void helper(TreeNode rootNode, StringBuilder curr, List<String> result) {
            if (curr.length() == 0) {
                curr.append(rootNode.val);
            } else {
                curr.append("->" + rootNode.val);
            }

            if (rootNode.left == null && rootNode.right == null) {
                result.add(curr.toString());
                return;
            }

            if (rootNode.left != null) {
                helper(rootNode.left, new StringBuilder(curr), result);
            }

            if (rootNode.right != null) {
                helper(rootNode.right, new StringBuilder(curr), result);
            }
        }
    }