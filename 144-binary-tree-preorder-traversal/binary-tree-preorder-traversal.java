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
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> arr=new ArrayList<>();
    //     helper(root,arr);
    //     return arr;
    // }
    // public void helper(TreeNode root,List<Integer> arr){
    //     if(root==null)return;
    //     arr.add(root.val);
    //     helper(root.left,arr);
    //     helper(root.right,arr);
    // }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        if(root==null) return arr;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            arr.add(curr.val);

            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
        }
        return arr;
    }
    
}