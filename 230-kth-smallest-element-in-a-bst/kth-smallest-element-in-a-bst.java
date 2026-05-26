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
    private int k=0;
    private int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        this.res=-1;
        inorder(root);
        return res;
    }
    public void inorder(TreeNode node){
        if(node!=null){
            inorder(node.left);
            if(--k==0){
                res=node.val;
                return;
            }
            inorder(node.right);
        }
    }
}