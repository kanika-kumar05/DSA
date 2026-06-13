class Solution {
    public static double power(double x,double n){
        if(n==0) return 1;
        if(n==1) return x;
        double nn=n;
        if(nn%2==0) return power(x*x,n/2);
        return x*power(x*x,(n-1)/2);
    }
    public double myPow(double x, int n) {
        double N=n;
        if(N<0) return 1/power(x,-N);
        return power(x,N);
    }
}