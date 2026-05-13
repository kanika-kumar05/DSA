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
    //     List<Integer> arr=new ArrayList<>();
    //     if(root==null) return arr;
    //     helper(root,arr);
    //     return arr;
    // }
    // public static void helper(TreeNode root,List<Integer> arr){
    //     if(root==null) return;
    //     helper(root.left,arr);
    //     helper(root.right,arr);
    //     arr.add(root.val);

    // }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        if(root==null) return arr;
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        TreeNode lastVisited=null;

        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode temp=st.peek().right;
                if(temp==null){
                    temp=st.peek();
                    st.pop();
                    arr.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp=st.peek();
                        st.pop();
                        arr.add(temp.val);
                    }

                }
                else{
                    curr=temp;
                }
            }
        }

        return arr;
        }
}