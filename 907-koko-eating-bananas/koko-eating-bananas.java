class Solution {
    public int find(int[] piles,int k){
        int total=0;
        for(int i=0;i<piles.length;i++){
            total+=Math.ceil((double)piles[i]/(double)k);
        }
        return total;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        Arrays.sort(piles);
        int high=piles[n-1];
        int low=1;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(find(piles,mid)<=h){
                ans=mid;
                high=mid-1;

            }
            else low=mid+1;
        }
        return ans;
    }
}