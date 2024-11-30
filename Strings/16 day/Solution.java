import java.util.HashMap;

public class Solution {
    // Function to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        // If the lengths are not the same, they can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a map to count character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count characters in the first string
        for (char ch : s1.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // Subtract counts using the second string
        for (char ch : s2.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
        }

        // Check if all counts are zero
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("Are '" + str1 + "' and '" + str2 + "' anagrams? " + areAnagrams(str1, str2)); // true

        str1 = "triangle";
        str2 = "integral";
        System.out.println("Are '" + str1 + "' and '" + str2 + "' anagrams? " + areAnagrams(str1, str2)); // true

        str1 = "apple";
        str2 = "pale";
        System.out.println("Are '" + str1 + "' and '" + str2 + "' anagrams? " + areAnagrams(str1, str2)); // false
    }
}
