class Solution {
    public int[] findnse(int[] num){
        Stack<Integer> st=new Stack<>();
        int n=num.length;
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && num[st.peek()]>=num[i]){
                st.pop();
            }
            
            if(st.isEmpty())res[i]=n;
            else res[i]=st.peek();
            st.push(i);
        }
        return res;
    }
    public int[] findpse(int[] num){
        Stack<Integer> st=new Stack<>();
        int n=num.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && num[st.peek()]>=num[i]){
                st.pop();
            }

            if(st.isEmpty())res[i]=-1;
            else res[i]=st.peek();
            st.push(i);
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nse=findnse(heights);
        int[] pse=findpse(heights);
        Stack<Integer> st=new Stack<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,heights[i]*(nse[i]-pse[i]-1));

        }
        return max;
    }


}