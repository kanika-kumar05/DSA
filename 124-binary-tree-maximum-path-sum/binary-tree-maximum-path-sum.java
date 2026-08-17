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
    public int helper(TreeNode node){
        if(node==null)return 0;

        int leftH=Math.max(0,helper(node.left));
        int rightH=Math.max(0,helper(node.right));

        maxSum=Math.max(maxSum,node.val+leftH+rightH);

        return node.val+Math.max(leftH,rightH);
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
}