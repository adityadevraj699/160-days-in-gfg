class Solution {
    public int myAtoi(String s) {
        // Step 1: Handle null or empty strings
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Step 2: Trim leading/trailing spaces
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        // Step 3: Initialize sign and starting index
        int sign = 1; // Default positive
        int index = 0;

        // Check for sign at the beginning
        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        // Step 4: Convert characters to integer
        int result = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0'; // Convert character to digit

            // Step 5: Check for overflow/underflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Accumulate the digit
            result = result * 10 + digit;
            index++;
        }

        // Step 6: Return final result with sign
        return result * sign;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        System.out.println(solution.myAtoi("42"));                  // Output: 42
        System.out.println(solution.myAtoi("   -42"));             // Output: -42
        System.out.println(solution.myAtoi("4193 with words"));    // Output: 4193
        System.out.println(solution.myAtoi("words and 987"));      // Output: 0
        System.out.println(solution.myAtoi("-91283472332"));       // Output: -2147483648 (Integer.MIN_VALUE)
        System.out.println(solution.myAtoi(" 1231231231311133"));  // Output: 2147483647 (Integer.MAX_VALUE)
        System.out.println(solution.myAtoi("  -"));                // Output: 0
    }
}
