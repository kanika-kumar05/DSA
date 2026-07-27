class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       
        int[][] dist=new int[n][n];
        // 1.firstly mark all cells as max
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        // mark the cells with already given wt
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int wt=it[2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        // 3. mark [i][i] nodes as zero
        for(int i=0;i<n;i++)dist[i][i]=0;

        // 4. floyd warshall
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int city=-1;
        int CityCount=n;
        // iterate on all cities for each city
        for(int i=0;i<n;i++){
            int count=0;
            for(int adjCity=0;adjCity<n;adjCity++){
                if(dist[i][adjCity]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=CityCount){
                city=i;
                CityCount=count;
            }
        }
        return city;
    }
}