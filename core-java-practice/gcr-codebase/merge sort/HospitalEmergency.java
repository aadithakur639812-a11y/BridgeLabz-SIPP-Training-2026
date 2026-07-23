import java.io.IOException;

public class HospitalEmergency {
    public static void main(String[] args) throws IOException {
        int n = (int) SortingInput.nextLong();
        long[] priorities = SortingInput.readArray(n);
        int k = (int) SortingInput.nextLong();
        System.out.println(kthHighest(priorities, k));
    }

    // Quickselect: expected O(N), without sorting the full array.
    private static long kthHighest(long[] values, int k) {
        int target = values.length - k, low = 0, high = values.length - 1;
        while (low <= high) {
            long pivot = values[low + (high - low) / 2];
            int i = low, j = high;
            while (i <= j) {
                while (values[i] < pivot) i++;
                while (values[j] > pivot) j--;
                if (i <= j) { long temp = values[i]; values[i++] = values[j]; values[j--] = temp; }
            }
            if (target <= j) high = j;
            else if (target >= i) low = i;
            else return values[target];
        }
        throw new IllegalArgumentException("k must be between 1 and N");
    }
}
