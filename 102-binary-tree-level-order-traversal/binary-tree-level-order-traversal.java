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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> arr=new ArrayList<>();
        if(root==null)return arr;
        q.offer(root);
        while(!q.isEmpty()){
            int len=q.size();
            List<Integer> sublist=new ArrayList<>();
            
            for(int i=0;i<len;i++){
                TreeNode temp=q.peek();
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
                sublist.add(q.poll().val);
            }
            arr.add(sublist);
        }
        return arr;
    }
}