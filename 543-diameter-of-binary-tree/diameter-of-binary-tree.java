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
    public int findHeight(TreeNode node){
        if(node==null)return 0;
        int lh=findHeight(node.left);
        int rh=findHeight(node.right);
        return 1+Math.max(lh,rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;

        int lh=findHeight(root.left);
        int rh=findHeight(root.right);
        int curr=lh+rh;

        int left=diameterOfBinaryTree(root.left);
        int right=diameterOfBinaryTree(root.right);

        return Math.max(curr,Math.max(left,right));

        
    }
}