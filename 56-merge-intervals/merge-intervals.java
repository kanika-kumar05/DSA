class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(e1,e2)->{
            return Integer.compare(e1[0],e2[0]);
        });
        ArrayList<int[]> arr=new ArrayList<>();
        arr.add(intervals[0]);
        int n=intervals.length;

        for(int i=1;i<n;i++){
            int[] ni=arr.get(arr.size()-1);
            if(intervals[i][0]<=ni[1]){ // if current start <= previous end
                ni[0]=Math.min(ni[0],intervals[i][0]);
                ni[1]=Math.max(ni[1],intervals[i][1]);
                arr.remove(arr.size()-1);
                arr.add(ni);
            }
            else arr.add(intervals[i]);
        }
        return arr.toArray(new int[arr.size()][]);
    }
}