class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue((e1,e2)->map.get(e1)-map.get(e2));

        for(int ele:map.keySet()){
            pq.add(ele);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i]=pq.poll();
            i++;
        }
        return res;
    }
}