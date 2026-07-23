import java.io.IOException;

public class EmployeePromotionConflicts {
    public static void main(String[] args) throws IOException {
        int n = (int) SortingInput.nextLong();
        long[] scores = SortingInput.readArray(n);
        System.out.println(countConflicts(scores, new long[n], 0, n - 1));
    }

    // Counts pairs i < j for which scores[i] < scores[j].
    private static long countConflicts(long[] a, long[] buffer, int left, int right) {
        if (left >= right) return 0;
        int middle = left + (right - left) / 2;
        long count = countConflicts(a, buffer, left, middle) + countConflicts(a, buffer, middle + 1, right);
        int i = left, j = middle + 1, k = left;
        while (i <= middle && j <= right) {
            if (a[i] < a[j]) { count += right - j + 1; buffer[k++] = a[i++]; }
            else buffer[k++] = a[j++];
        }
        while (i <= middle) buffer[k++] = a[i++];
        while (j <= right) buffer[k++] = a[j++];
        for (i = left; i <= right; i++) a[i] = buffer[i];
        return count;
    }
}
