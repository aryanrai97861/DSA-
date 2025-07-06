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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
            //no child
            if(root.left==null && root.right==null) return null;
            //one child
            else if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }
            //two child
            else{
                TreeNode successor=findMin(root.right);
                root.val=successor.val;
                root.right=deleteNode(root.right,successor.val);
            }
        }
        return root;
    }
    private TreeNode findMin(TreeNode node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
}