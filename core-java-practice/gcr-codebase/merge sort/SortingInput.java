import java.io.BufferedInputStream;
import java.io.IOException;

/** Small input helper that accepts whitespace and optional [ ] / commas. */
class SortingInput {
    private static final BufferedInputStream INPUT = new BufferedInputStream(System.in);

    static long nextLong() throws IOException {
        int character;
        do {
            character = INPUT.read();
        } while (character != '-' && (character < '0' || character > '9'));

        boolean negative = character == '-';
        long value = 0;
        if (negative) character = INPUT.read();
        while (character >= '0' && character <= '9') {
            value = value * 10 + character - '0';
            character = INPUT.read();
        }
        return negative ? -value : value;
    }

    static long[] readArray(int size) throws IOException {
        long[] values = new long[size];
        for (int i = 0; i < size; i++) values[i] = nextLong();
        return values;
    }

    static void printArray(long[] values) {
        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < values.length; i++) {
            if (i > 0) output.append(' ');
            output.append(values[i]);
        }
        System.out.println(output.append(']'));
    }
}
