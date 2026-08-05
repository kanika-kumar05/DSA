import java.util.*;

class Solution {

    public int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        return nse;
    }

    public int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;

        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            sum = (sum + (arr[i] * left * right) % mod) % mod;
        }

        return (int) sum;
    }
}