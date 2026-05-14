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
    public static int findLeft(TreeNode node){
        if(node==null)return 0;
        
        int left=findLeft(node.left);
        int right=findRight(node.right);
        return 1+Math.max(left,right);
    }

    public static int findRight(TreeNode node){
        if(node==null)return 0;
        
        int left=findLeft(node.left);
        int right=findRight(node.right);
        return 1+Math.max(left,right);
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;

        int left=findLeft(root.left);
        int right=findRight(root.right);

        if(Math.abs(left-right)>1)return false;

        boolean leftH=isBalanced(root.left);
        boolean rightH=isBalanced(root.right);

        if(!leftH || !rightH)return false;
        return true;
    }
}