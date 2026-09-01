class Solution {
    public int[] minmax(int[] nums){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i]>max)max=nums[i];
        }
        return new int[] {max,sum};
    }
    public int find(int[] nums,int maxWeight){
        int weight=0;
        int days=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+weight>maxWeight){
                days++;
                weight=nums[i];
            }
            else weight+=nums[i];       
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int[] res=minmax(weights);
        int low=res[0],high=res[1];
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(find(weights,mid)<=days){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}