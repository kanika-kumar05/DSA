class Solution {
    public int[] findnse(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=n;
            }
            else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public int[] findpse(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public int[] findnge(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=n;
            }
            else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public int[] findpge(int[] nums){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int mod=(int)1e9+7;
        int[] nse=findnse(nums);
        int[] pse=findpse(nums);
        int[] nge=findnge(nums);
        int[] pge=findpge(nums);
        long largestTotal=0,smallestTotal=0;

        for(int i=0;i<n;i++){
            int largestLeft=i-pge[i];
            int largestRight=nge[i]-i;
            int smallestLeft=i-pse[i];
            int smallestRight=nse[i]-i;
            largestTotal+=(long)nums[i]*largestLeft*largestRight;
            smallestTotal+=(long)nums[i]*smallestLeft*smallestRight;
        }
        return largestTotal-smallestTotal;
    }
}