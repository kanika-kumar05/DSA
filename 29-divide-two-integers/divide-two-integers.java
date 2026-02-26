class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor) return 1;
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        Boolean sign=true;
        if((dividend<0 && divisor>0)||(dividend>0 && divisor<0)) sign=false;
        long ans=0;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        while(n>=d){
            int count=0;
            while(n>=(d<<count)){
                count++;
            }
            count--;
            ans+=(1L<<count);
            n=n-(d<<count);
        }
        return sign?(int)(ans):(int)(-1*ans);
    }
}