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
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     if(root==null)return arr;
    //     helper(root,arr);
    //     return arr;
    // }
    // public void helper(TreeNode root,ArrayList<Integer> arr){
    //     if(root==null)return;
    //     helper(root.left,arr);
    //     helper(root.right,arr);
    //     arr.add(root.val);
    // }

    // public List<Integer> postorderTraversal(TreeNode root){
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     if(root==null)return arr;
    //     Stack<TreeNode> st=new Stack<>();
    //     TreeNode curr=root;
    //     while(curr!=null || !st.isEmpty()){
    //         if(curr!=null){
    //             st.push(curr);
    //             curr=curr.left;
    //         }
    //         else{
    //             TreeNode temp=st.peek().right;
    //             if(temp==null){
    //                 temp=st.peek();
    //                 st.pop();
    //                 arr.add(temp.val);
    //                 while(!st.isEmpty() && temp==st.peek().right){
    //                     temp=st.peek();
    //                     st.pop();
    //                     arr.add(temp.val);
    //                 }
    //             }
    //             else{
    //                 curr=temp;
    //             }
    //         }
    //     }
    //     return arr;
    // }

    public List<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> arr=new ArrayList<>();
        if(root==null)return arr;
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode temp=st1.peek();
            st2.push(temp);
            st1.pop();
            if(temp.left!=null)st1.push(temp.left);
            if(temp.right!=null)st1.push(temp.right);

        }
        while(!st2.isEmpty()){
            arr.add(st2.pop().val);
        }
        return arr;

    }
}