class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)return false;

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:map.keySet()){
            pq.add(num);
        }

        while(!pq.isEmpty()){
            int first=pq.peek();
            for(int i=0;i<groupSize;i++){
                int card=first+i;

                if(!map.containsKey(card))return false;

                map.put(card,map.get(card)-1);

                if(map.get(card)==0){
                    map.remove(card);
                    pq.remove(card);
                }
            }
        }
        return true;
    }
}