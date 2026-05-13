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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> arr=new ArrayList<>();
    //     if(root==null) return arr;
    //     helper(root,arr);
    //     return arr;
    // }
    // public void helper(TreeNode root, List<Integer> arr){
    //     if(root==null)return;
    //     helper(root.left,arr);
    //     arr.add(root.val);
    //     helper(root.right,arr);
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        if(root==null) return arr;
        Stack<TreeNode> st=new Stack<>();
        TreeNode node=root;

        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                else{
                    node=st.pop();
                    arr.add(node.val);
                    node=node.right;
                }
            }
        }
        return arr;
    }
    
}