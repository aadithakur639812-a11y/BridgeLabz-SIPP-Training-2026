import java.io.IOException;

public class MergeCustomerRecords {
    // Input: N, N sorted IDs, M, M sorted IDs.
    public static void main(String[] args) throws IOException {
        int n = (int) SortingInput.nextLong();
        long[] first = SortingInput.readArray(n);
        int m = (int) SortingInput.nextLong();
        long[] second = SortingInput.readArray(m);
        long[] merged = new long[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) merged[k++] = first[i] <= second[j] ? first[i++] : second[j++];
        while (i < n) merged[k++] = first[i++];
        while (j < m) merged[k++] = second[j++];
        SortingInput.printArray(merged);
    }
}
