class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e2[1] - e1[1];   // larger index first
            }
            return e2[0] - e1[0];       // more soldiers first
        });

        // Add all rows
        for (int i = 0; i < r; i++) {
            int count = 0;

            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0)
                    break;

                count++;
            }

            pq.add(new int[]{count, i});
        }

        // Remove strongest r-k rows
        for (int i = 0; i < r - k; i++) {
            pq.poll();
        }

        // Remaining k rows are the weakest
        int[] res = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll()[1];
        }

        return res;
    }
}