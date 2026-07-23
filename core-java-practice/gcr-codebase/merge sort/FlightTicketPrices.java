import java.io.IOException;

public class FlightTicketPrices {
    public static void main(String[] args) throws IOException {
        int n = (int) SortingInput.nextLong();
        long[] prices = SortingInput.readArray(n);
        quickSort(prices, 0, n - 1);
        SortingInput.printArray(prices);
    }

    // Median pivot plus three-way partition avoids poor behavior with duplicate prices.
    private static void quickSort(long[] values, int low, int high) {
        if (low >= high) return;
        long pivot = values[low + (high - low) / 2];
        int less = low, current = low, greater = high;
        while (current <= greater) {
            if (values[current] < pivot) swap(values, less++, current++);
            else if (values[current] > pivot) swap(values, current, greater--);
            else current++;
        }
        quickSort(values, low, less - 1);
        quickSort(values, greater + 1, high);
    }

    private static void swap(long[] values, int first, int second) {
        long temp = values[first]; values[first] = values[second]; values[second] = temp;
    }
}
