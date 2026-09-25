class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<hand.length;i++){
            hm.put(hand[i],hm.getOrDefault(hand[i],0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int ele:hm.keySet()){
            pq.add(ele);
        }
        
        while(!pq.isEmpty()){
            int ele=pq.peek();
            for(int i=0;i<groupSize;i++){
                int card=ele+i;
                if(!hm.containsKey(card))return false;
                hm.put(card,hm.get(card)-1);
                if(hm.get(card)==0){
                    hm.remove(card);
                    pq.remove(card);
                }
            }

        }
        return true;
    }
}