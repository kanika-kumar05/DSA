class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;

        PriorityQueue<int[]> pq=new PriorityQueue<>((e1,e2)->{
            if(e1[0]==e2[0]){
                return e2[1]-e1[1];
            }
            return e2[0]-e1[0];
        });

        for (int i = 0; i < r; i++) {
            int count = 0;
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0)
                    break;
                count++;
            }
            pq.add(new int[]{
                count,i
            });
            if(pq.size()>k){
                pq.poll();
            }
        }

        

        int[] res=new int[k];
        for(int i=k-1;i>=0;i--){
            res[i]=pq.poll()[1];
        }
        return res;
    }

}