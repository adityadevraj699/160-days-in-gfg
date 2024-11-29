class Solution {
    public String addBinary(String s1, String s2) {
        int i = s1.length() - 1; // Pointer for the first string
        int j = s2.length() - 1; // Pointer for the second string
        int carry = 0;           // Carry for binary addition
        StringBuilder result = new StringBuilder(); // To store the result

        // Perform binary addition
        while (i >= 0 || j >= 0 || carry > 0) {
            // Get the current bits, or 0 if the index is out of bounds
            int bit1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int bit2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = bit1 + bit2 + carry; // Sum of bits and carry

            result.append(sum % 2); // Append the current bit to the result
            carry = sum / 2;        // Update the carry

            i--; // Move to the next bit in s1
            j--; // Move to the next bit in s2
        }

        // Reverse the result to get the correct order
        result.reverse();

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString(); // Return the final binary sum
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "1101";
        String s2 = "111";
        System.out.println(solution.addBinary(s1, s2)); // Output: 10100

        // Test Case 2
        String s3 = "00100";
        String s4 = "010";
        System.out.println(solution.addBinary(s3, s4)); // Output: 110

        // Test Case 3
        String s5 = "0";
        String s6 = "0";
        System.out.println(solution.addBinary(s5, s6)); // Output: 0

        // Test Case 4
        String s7 = "1010";
        String s8 = "1011";
        System.out.println(solution.addBinary(s7, s8)); // Output: 10101
    }
}
