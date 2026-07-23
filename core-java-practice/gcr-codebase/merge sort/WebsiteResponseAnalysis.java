import java.io.IOException;

public class WebsiteResponseAnalysis {
    public static void main(String[] args) throws IOException {
        int n = (int) SortingInput.nextLong();
        long[] times = SortingInput.readArray(n);
        System.out.println(countViolations(times, new long[n], 0, n - 1));
    }

    private static long countViolations(long[] a, long[] buffer, int left, int right) {
        if (left >= right) return 0;
        int middle = left + (right - left) / 2;
        long count = countViolations(a, buffer, left, middle) + countViolations(a, buffer, middle + 1, right);
        int i = left, j = middle + 1, k = left;
        while (i <= middle && j <= right) {
            if (a[i] <= a[j]) buffer[k++] = a[i++];
            else { count += middle - i + 1; buffer[k++] = a[j++]; }
        }
        while (i <= middle) buffer[k++] = a[i++];
        while (j <= right) buffer[k++] = a[j++];
        for (i = left; i <= right; i++) a[i] = buffer[i];
        return count;
    }
}
