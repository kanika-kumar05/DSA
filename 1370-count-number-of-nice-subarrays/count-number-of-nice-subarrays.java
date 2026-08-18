class Solution {
    public int find(int[] nums,int k){
        if(k<0)return 0;
        int l=0,sum=0,count=0,n=nums.length;

        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum>k){
                sum-=nums[l];
                l++;
            }
            count+=r-l+1;
        }
        return count;

    }
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0)nums[i]=0;
            else nums[i]=1;
        }
        
        int x=find(nums,k);
        int y=find(nums,k-1);
        return x-y;
    }
}