class Solution {
    public static int firstOccur(int[] nums,int target){
        int n=nums.length;
        int low=0, high=n-1;
        int first=n;

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=target){
                first=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return first;
    }

    public static int lastOccur(int[] nums,int target){
        int n=nums.length;
        int low=0, high=n-1;
        int last=n;

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>target){
                last=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int first=firstOccur(nums,target);
        int n=nums.length;
        if(first==n || nums[first]!=target) return new int[]{-1,-1};
        return new int[]{first,lastOccur(nums,target)-1};
    }
}