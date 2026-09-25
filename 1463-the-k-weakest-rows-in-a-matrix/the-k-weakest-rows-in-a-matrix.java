class Solution {
    public int count(int[] row){
        int low=0,high=row.length-1;
        int index=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(row[mid]==1){
                index=mid;
                low=mid+1;
            }
            else high=mid-1;

        }
        return index+1;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            int ones=count(mat[i]);
            hm.put(i,ones);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((e1,e2)->{
            if(hm.get(e1)!=hm.get(e2)){
                return hm.get(e1)-hm.get(e2);
            }
            return e1-e2;
        });
        for(int ele:hm.keySet()){
            pq.add(ele);

        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }
        return res;
    }
}