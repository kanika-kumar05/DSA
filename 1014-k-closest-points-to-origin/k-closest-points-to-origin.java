class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((e1,e2)->{
            return (e1[0]*e1[0]+e1[1]*e1[1])-(e2[0]*e2[0]+e2[1]*e2[1]);
        });
        for(int i=0;i<n;i++){
            pq.add(points[i]);
        }
        int[][] res=new int[k][2];
        int j=0;
        while(j<k){
            res[j]=pq.poll();
            j++;
        }
        return res;
    }
}