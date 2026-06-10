class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjRev=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++){
            adjRev.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int it:graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            ans.add(node);

            for(int it:adjRev.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}