class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] left=new int[n+1];
        // int[] right=new int[n+1];
        // int ans=0;

        left[0]=1;
        // right[n-1]=1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;

            }
            else left[i]=1;
        }


        // for(int i=n-2;i>=0;i--){
        //     if(ratings[i]>ratings[i+1]){
        //         right[i]=right[i+1]+1;

        //     }
        //     else right[i]=1;
        // }

        int ans=Math.max(left[n-1],1);
        int right=1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right=right+1;
            }
            else right=1;
            ans+=Math.max(left[i],right);
        }
        // for(int i=0;i<n;i++){
        //     ans+=Math.max(left[i],right[i]);
        // }
       return ans;
    }
}