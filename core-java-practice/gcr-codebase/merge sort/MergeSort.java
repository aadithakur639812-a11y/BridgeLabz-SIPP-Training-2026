class MergeSort {
    static void sort(long[] values) {
        if (values.length > 1) sort(values, new long[values.length], 0, values.length - 1);
    }

    private static void sort(long[] values, long[] buffer, int left, int right) {
        if (left >= right) return;
        int middle = left + (right - left) / 2;
        sort(values, buffer, left, middle);
        sort(values, buffer, middle + 1, right);
        int i = left, j = middle + 1, k = left;
        while (i <= middle && j <= right) buffer[k++] = values[i] <= values[j] ? values[i++] : values[j++];
        while (i <= middle) buffer[k++] = values[i++];
        while (j <= right) buffer[k++] = values[j++];
        for (i = left; i <= right; i++) values[i] = buffer[i];
    }
}
