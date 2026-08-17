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

class Tuple{
    TreeNode node;
    int vert,col;
    Tuple(TreeNode node,int vert,int col){
        this.node=node;
        this.vert=vert;
        this.col=col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> arr=new ArrayList<>();
        if(root==null)return arr;

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();

        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            TreeNode node=q.peek().node;
            int y=q.peek().vert;
            int x=q.peek().col;
            q.poll();

            if(!map.containsKey(y)){
                map.put(y,new TreeMap<>());
            }
            if(!map.get(y).containsKey(x)){
                map.get(y).put(x,new PriorityQueue<>());
            }
            map.get(y).get(x).offer(node.val);

            if(node.left!=null){
                q.offer(new Tuple(node.left,y-1,x+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,y+1,x+1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>>ys:map.values()){
            arr.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:ys.values()){
                while(!nodes.isEmpty()){
                    arr.get(arr.size()-1).add(nodes.poll());
                }
            }
        }
        return arr;
    }
}