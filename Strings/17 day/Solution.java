import java.util.HashMap;

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // If the string is empty, return the null character
        if (s.length() == 0) {
            return '\0';
        }

        // Step 1: Count the occurrences of each character
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find the first non-repeating character
        for (char ch : s.toCharArray()) {
            if (charCount.get(ch) == 1) {
                return ch; // Return the first character with a count of 1
            }
        }

        // If no non-repeating character is found, return '$'
        return '$';
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        // Test cases
        String s1 = "geeksforgeeks";
        String s2 = "racecar";
        String s3 = "aabbccc";
        String s4 = "abcd";

        System.out.println(nonRepeatingChar(s1)); // Output: f
        System.out.println(nonRepeatingChar(s2)); // Output: e
        System.out.println(nonRepeatingChar(s3)); // Output: $
        System.out.println(nonRepeatingChar(s4)); // Output: a
    }
}
