class Solution {
    public int find(int[] nums,int goal){
        if(goal<0)return 0;
        int l=0,sum=0,count=0,n=nums.length;

        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            count+=r-l+1;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {

        int x=find(nums,goal);
        int y=find(nums,goal-1);
        return x-y;
    }
}