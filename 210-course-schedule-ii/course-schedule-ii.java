class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int n=numCourses;
        int m=prerequisites.length;
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[]topo=new int[n];
        int index=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo[index++]=node;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)q.add(it);
            }
        }
        if(index==n)return topo;
        int[] arr={};
        return arr;
    }
}