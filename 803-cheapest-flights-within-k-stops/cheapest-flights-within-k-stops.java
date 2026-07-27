class Pair{
    int node,wt;
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}
class tuple{
    int stops,node,wt;
    tuple(int stops,int node,int wt){
        this.stops=stops;
        this.node=node;
        this.wt=wt;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:flights){
            int u=it[0];
            int v=it[1];
            int wt=it[2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] dist=new int[n];
        for(int i=0;i<n;i++)dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        Queue<tuple> q=new LinkedList<>();
        q.add(new tuple(0,src,0));
        while(!q.isEmpty()){
            int stopss=q.peek().stops;
            int node=q.peek().node;
            int wt=q.peek().wt;
            q.remove();
            if(stopss>k)continue;
            for(Pair it:adj.get(node)){
                int adjNode=it.node;
                int adjWt=it.wt;
                if(wt+adjWt<dist[adjNode]){
                    dist[adjNode]=wt+adjWt;
                    q.add(new tuple(stopss+1,adjNode,wt+adjWt));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)return -1;
        return dist[dst];
    }
}