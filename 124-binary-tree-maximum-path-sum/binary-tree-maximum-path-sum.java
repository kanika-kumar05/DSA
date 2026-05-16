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
    int maxSum=Integer.MIN_VALUE;
    public  int help(TreeNode node){
        if(node==null) return 0;
        int leftSum=Math.max(0,help(node.left));
        int rightSum=Math.max(0,help(node.right));
        maxSum=Math.max(maxSum,(node.val+leftSum+rightSum));
        return (node.val)+Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        
        int ans=help(root);
        return maxSum;
    }

}