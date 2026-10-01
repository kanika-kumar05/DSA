class Solution {
    public int findFirst(int[] nums,int target){
        int low=0,high=nums.length-1;
        int index=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                index=mid;
                high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else low=mid+1;
        }
        return index;
    }

    public int findLast(int[] nums,int target){
        int low=0,high=nums.length-1;
        int index=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                index=mid;
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else low=mid+1;
        }
        return index;
    }
    public int[] searchRange(int[] nums, int target) {
        int index=findFirst(nums,target);
        if(index==-1)return new int[]{-1,-1};
        int last=findLast(nums,target);
        return new int[]{index,last};
    }
}