public class MergeSort {
    private int[] helpers;
    private int[] numbers;
    private int number;

    public void sort(int[] numbers) {
        this.numbers = numbers;
        this.number = numbers.length;
        this.helpers = new int[number];
        this.split(this.numbers, 0, this.number - 1);

    }

    private void split(int[] numbers, int low, int high) {
        if (low < high - 1) {
            int middle = (high - low) / 2;
            this.split(numbers, low, middle);
            this.split(numbers, middle + 1, high);
            this.merge(numbers, low, middle, high);
        }
    }

    private void merge(int[] numbers, int low, int middle, int high) {
        for (int i = low; i < high; i++) {
            helpers[i] = numbers[i];
        }

        i = low;
        j = middle + 1;
        k = low;

        while (i <= middle && j <= high) {
            if (helpers[i] < helpers[j]) {
                numbers[k] = helpers[i];
                i++;
            } else if (helpers[i] > helpers[j]) {
                numbers[k] = helpers[j];
                j++;
            }
            k++;

        }

        // while (i)
    }
}
