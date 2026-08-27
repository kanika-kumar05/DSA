import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Max Heap based on frequency
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((e1, e2) -> map.get(e2) - map.get(e1));

        // Add all elements
        for (int ele : map.keySet()) {
            pq.add(ele);
        }

        // Get k most frequent elements
        int[] res = new int[k];

        int i=0;
        while(i<k){
            res[i]=pq.poll();
            i++;
        }
        return res;
    }
}