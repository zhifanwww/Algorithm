public class MergeSort {
    private int[] numbers;
    private int[] helper;
    private int number;

    public void sort(int[] numbers) {
        this.numbers = numbers; // this只是为了表示赋值到private member variable
        number = numbers.length;
        helper = new int[number];
        splitMerge(0, number - 1); // 起始index
    }

    private void splitMerge(int low, int high) {
        if (low < high) { // 递归终止条件
            middle = low + (high - low) / 2;
            splitMerge(low, middle);
            splitMerge(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private merge(int low, int middle, int high){
        for (int i=low; i<=high; i++){
            helper[i] = numbers[i];
        }

        int i = low;
        int k = low;
        int j = middle + 1;

        // merge sort的核心是sort两个sorted array
        while (i<=low && j<=high){
            if (helper[i] <= helper[j]){
                numbers[k] = helper[i];
                i++;
            }
            else{
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        while(i<=low){
            numbers[k] = helper[i];
            k++;
            i++;
        }
        while(j<=high){
            numbers[k] = helper[j];
            k++;
            j++;
        }
        
    }
}
