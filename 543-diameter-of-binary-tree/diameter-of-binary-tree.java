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
    public static int findHeight(TreeNode node){
        if(node==null)return 0;
        
        int left=findHeight(node.left);
        int right=findHeight(node.right);
        return 1+Math.max(left,right);
    }



    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        
        int left=findHeight(root.left);
        int right=findHeight(root.right);

        int curr=left+right;

        int leftH=diameterOfBinaryTree(root.left);
        int rightH=diameterOfBinaryTree(root.right);
        
        return Math.max(curr,Math.max(leftH,rightH));

    }
}