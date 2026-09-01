class Solution {
    public int[] minmax(int[] arr){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)max=arr[i];
            if(arr[i]<min)min=arr[i];
        }
        return new int[]{max,min};
    }
    public boolean find(int[] arr,int mid,int m,int k){
        int flowers=0, bouquet=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                flowers++;

                if(flowers==k){
                    bouquet++;
                    flowers=0;
                }
            }
            else flowers=0;
        }
        return bouquet>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int[] ans=minmax(bloomDay);
        int low=ans[1],high=ans[0];
        int anss=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(find(bloomDay,mid,m,k)){
                anss=mid;
                high=mid-1;
            }
            else low=mid+1;

        }
        return anss;
    }
}