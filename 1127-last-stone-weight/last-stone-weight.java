class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:stones){
            pq.add(num);
        }
        if(pq.size()==1) return pq.peek();
        while(pq.size()>1){
            int temp1=pq.poll();
            int temp2=pq.poll();
            if(temp1!=temp2){
                pq.add(Math.abs(temp1-temp2));
            }
        } 
        return pq.isEmpty()?0:pq.peek();
    }
}