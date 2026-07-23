import java.io.IOException;

public class BankFraudDetection {
    public static void main(String[] args) throws IOException {
        int n = (int) SortingInput.nextLong();
        long[] amounts = SortingInput.readArray(n);
        System.out.println(countSuspiciousPairs(amounts, new long[n], 0, n - 1));
    }

    private static long countSuspiciousPairs(long[] a, long[] buffer, int left, int right) {
        if (left >= right) return 0;
        int middle = left + (right - left) / 2;
        long count = countSuspiciousPairs(a, buffer, left, middle) + countSuspiciousPairs(a, buffer, middle + 1, right);
        int j = middle + 1;
        for (int i = left; i <= middle; i++) {
            while (j <= right && a[i] > 3L * a[j]) j++;
            count += j - (middle + 1);
        }
        int i = left; j = middle + 1; int k = left;
        while (i <= middle && j <= right) buffer[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= middle) buffer[k++] = a[i++];
        while (j <= right) buffer[k++] = a[j++];
        for (i = left; i <= right; i++) a[i] = buffer[i];
        return count;
    }
}
