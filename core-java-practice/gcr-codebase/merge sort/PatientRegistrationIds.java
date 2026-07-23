import java.io.IOException;

public class PatientRegistrationIds {
    public static void main(String[] args) throws IOException {
        int n = (int) SortingInput.nextLong();
        long[] ids = SortingInput.readArray(n);
        MergeSort.sort(ids);
        SortingInput.printArray(ids);
    }
}
