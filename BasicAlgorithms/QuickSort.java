public class QuickSort {
    public void sort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    private void quickSort(int[] numbers, int left, int right) {
        if (left < right) {// recursion ending condition
            int pivotIndex = partition(numbers, left, right);
            quickSort(numbers, left, pivotIndex);
            quickSort(numbers, pivotIndex + 1, right);
        }
    }

    private int partition(int[] numbers, int left, int right) {
        int pivot = numbers[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (numbers[j] <= pivot) { // less equal
                swap(numbers, ++i, j);
            }
        }
        swap(numbers, ++i, right);
        return i;
    }
}