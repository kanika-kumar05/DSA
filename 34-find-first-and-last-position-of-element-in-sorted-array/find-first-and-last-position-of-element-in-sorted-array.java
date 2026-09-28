class Solution {
    public int lower(int[] nums,int target){
        int n=nums.length;
        int low=0,high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(ans<n && nums[ans]==target)return ans;
        return -1;
    }
    public int upper(int[] nums,int target){
        int n=nums.length;
        int low=0,high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int lb=lower(nums,target);
        if(lb==-1){
            return new int[]{-1,-1};
        }
        int ub=upper(nums,target);
        return new int[]{lb,ub-1};
    }
}