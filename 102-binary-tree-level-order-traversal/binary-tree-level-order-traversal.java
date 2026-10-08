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
        List<List<Integer>> arr=new ArrayList<>();
        if(root==null)return arr;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int len=q.size();
            arr.add(new ArrayList<>());
            for(int i=0;i<len;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
                arr.get(arr.size()-1).add(temp.val);
            }
        }
        return arr;
    }
}