class Solution {
    public int getSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Second largest element: " + solution.getSecondLargest(arr));
        
        int[] arr2 = {5, 5, 5, 5};
        try {
            System.out.println("Second largest element: " + solution.getSecondLargest(arr2));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
