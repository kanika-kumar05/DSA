class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(e1,e2)->{
            return Integer.compare(e1[0],e2[0]);
        });
        ArrayList<int[]> arr=new ArrayList<>();
        arr.add(intervals[0]);

        for(int curr=1;curr<intervals.length;curr++){
            int[] prev=arr.get(arr.size()-1);
            if(intervals[curr][0]<=prev[1]){
                prev[0]=Math.min(prev[0],intervals[curr][0]);
                prev[1]=Math.max(prev[1],intervals[curr][1]);
                arr.remove(arr.get(arr.size()-1));
                arr.add(prev);
            }
            else arr.add(intervals[curr]);
        }
        return arr.toArray(new int[arr.size()][]);
    }
}