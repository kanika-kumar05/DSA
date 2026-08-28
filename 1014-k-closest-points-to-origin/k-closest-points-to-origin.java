class Solution {
    public int dist(int i, int j) {
        return i*i+j*j;
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
            return dist(e2[0], e2[1]) - dist(e1[0], e1[1]);
        });

        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
            if (pq.size() > k)
                pq.poll();
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        return ans;

    }
}