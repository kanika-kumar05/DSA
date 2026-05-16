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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag=true;
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> q=new LinkedList<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            Integer[] arr=new Integer[size];
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                int index=flag ? i:size-i-1;
                arr[index]=node.val;

                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);

            }
            flag=!flag;
            res.add(Arrays.asList(arr));

        }
        return res;
    }
}