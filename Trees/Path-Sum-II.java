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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        backtrack(root,targetSum,current,result);
        return result;
    }
    private void backtrack(TreeNode node,int targetSum,List<Integer> current,List<List<Integer>> result){
        if(node==null) return;
        current.add(node.val);
        if(node.left==null && node.right==null && node.val==targetSum){
            result.add(new ArrayList<>(current));
        }else{
            backtrack(node.left,targetSum-node.val,current,result);
            backtrack(node.right,targetSum-node.val,current,result);
        }
        current.remove(current.size()-1);
    }
}