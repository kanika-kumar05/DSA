class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, maxLen = 0, len = 0;
        int n = nums.length;
        int zeros = 0;
        for(int r=0;r<n;r++){
            if(nums[r]==0){
                zeros++;
            }
            if(zeros>k){
                if(nums[l]==0){
                    zeros--;
                }
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}