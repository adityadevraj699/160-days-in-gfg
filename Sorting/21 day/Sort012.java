public class Sort012 {
    public void sort012(int[] arr) {
        // Initialize pointers
        int low = 0, mid = 0, high = arr.length - 1;

        // Traverse the array
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid], then increment low and mid
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // Just move the mid pointer
                mid++;
            } else { // arr[mid] == 2
                // Swap arr[mid] and arr[high], then decrement high
                swap(arr, mid, high);
                high--;
            }
        }
    }

    // Helper function to swap two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Sort012 sorter = new Sort012();
        int[] arr1 = {0, 1, 2, 0, 1, 2};
        int[] arr2 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        sorter.sort012(arr1);
        sorter.sort012(arr2);

        System.out.println("Sorted arr1: " + java.util.Arrays.toString(arr1));
        System.out.println("Sorted arr2: " + java.util.Arrays.toString(arr2));
    }
}
