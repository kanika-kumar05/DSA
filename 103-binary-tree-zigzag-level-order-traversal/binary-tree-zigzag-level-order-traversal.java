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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();
        if (root == null)
            return arr;
        q.offer(root);
        int flag = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode temp = q.peek();
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
                sublist.add(q.poll().val);
            }
            if (flag == 1)
                Collections.reverse(sublist);
            arr.add(sublist);
            flag = 1 - flag;
        }
        return arr;
    }
}