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
    public int goodNodes(TreeNode root) {
        return helper(root,root.val);
    }
    private int helper(TreeNode node,int highest){
        if(node==null) return 0;
        int count=0;
        if(node.val>=highest){
            count++;
        }
        int newMax=Math.max(highest,node.val);
        count+=helper(node.left,newMax);
        count+=helper(node.right,newMax);

        return count;
    }
}