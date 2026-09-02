class Solution {
    public int[] minmax(int[] nums){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i]>max)max=nums[i];
        }
        return new int[]{max,sum};
    }
    public boolean find(int[] nums,int maxSum,int k){
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>maxSum){
                count++;
                sum=nums[i];
            }
            else sum+=nums[i];
        }
        return count<=k;
    }
    public int splitArray(int[] nums, int k) {
        int[] res=minmax(nums);
        int low=res[0],high=res[1];
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(find(nums,mid,k)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}