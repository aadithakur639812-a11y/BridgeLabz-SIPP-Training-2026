import java.io.IOException;

public class CustomerOrderValues {
    public static void main(String[] args) throws IOException {
        int n = (int) SortingInput.nextLong();
        long[] orders = SortingInput.readArray(n);
        MergeSort.sort(orders);
        SortingInput.printArray(orders);
    }
}
