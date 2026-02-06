class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // Compute factorials from 0! to n!
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Create a list of numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--; // Convert to 0-based index

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.remove(index));
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }
}