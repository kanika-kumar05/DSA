class Solution {
    public int[] minmax(int[] arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min)min=arr[i];
            if(arr[i]>max)max=arr[i];
        }
        return new int[]{min,max};
    }
    public int find(int[] nums,int k){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/k);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int[] res=minmax(nums);
        int low=1,high=res[1];
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(find(nums,mid)<=threshold){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}