import java.io.IOException;

public class EmployeeSalaries {
    public static void main(String[] args) throws IOException {
        int n = (int) SortingInput.nextLong();
        long[] salaries = SortingInput.readArray(n);
        MergeSort.sort(salaries);
        SortingInput.printArray(salaries);
    }
}
