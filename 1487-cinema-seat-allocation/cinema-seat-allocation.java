import java.util.*;

class Solution {
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int m = reservedSeats.length;

        HashMap<Integer, Integer> seat = new HashMap<>();

        for (int[] r : reservedSeats) {
            int i = r[0] - 1;
            int j = r[1] - 2;

            if (j < 0 || j >= 8) continue;

            seat.put(i, seat.getOrDefault(i, 0) | (1 << j));
        }

        int sz = seat.size();

        int cnt = (n - sz) * 2;

        int A = 15;
        int B = 15 << 2;
        int C = 15 << 4;
        int D = A | C;

        for (int S : seat.values()) {
            S = (~S) & 255;

            boolean has2 = (S & D) == D;

            boolean has1 = !has2 &&
                    ((S & A) == A ||
                     (S & B) == B ||
                     (S & C) == C);

            if (has2) {
                cnt += 2;
            }

            if (has1) {
                cnt += 1;
            }
        }
        return cnt;
    }
}