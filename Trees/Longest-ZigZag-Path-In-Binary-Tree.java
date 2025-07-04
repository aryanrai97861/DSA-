/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max=0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        helper(root.left,true,1);
        helper(root.right,false,1);
        return max;
    }
    private void helper(TreeNode node,boolean isLeft,int count){
        if(node==null){
            return;
        }
        max=Math.max(max,count);
        if(isLeft){
            helper(node.right,false,count+1);
            helper(node.left,true,1);
        }else{
            helper(node.left,true,count+1);
            helper(node.right,false,1);
        }
    }
}