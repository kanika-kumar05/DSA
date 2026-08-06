class Solution {
    public int[] findnse(int[] num) {
        Stack<Integer> st = new Stack<>();
        int n = num.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && num[st.peek()] >= num[i]) {
                st.pop();
            }

            if (st.isEmpty())
                res[i] = n;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] findpse(int[] num) {
        Stack<Integer> st = new Stack<>();
        int n = num.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && num[st.peek()] >= num[i]) {
                st.pop();
            }

            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int max = Integer.MIN_VALUE;
        // Arrays.fill(heights, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1')
                    heights[j] += 1;
                else
                    heights[j] = 0;
            }
            int[] nse = findnse(heights);
            int[] pse = findpse(heights);
            
            for (int j = 0; j < m; j++) {
                max = Math.max(max, heights[j] * (nse[j] - pse[j] - 1));
            }
        }

        return max;
    }
}