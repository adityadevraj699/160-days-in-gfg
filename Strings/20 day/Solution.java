class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // If lengths are not equal, they can't be rotations
        if (s1.length() != s2.length()) {
            return false;
        }

        // Concatenate s1 with itself
        String concatenated = s1 + s1;

        // Use KMP algorithm to check if s2 is a substring of concatenated
        return kmpSearch(concatenated, s2);
    }

    // KMP Search function to find if the pattern exists in the text
    private static boolean kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Build the prefix array for the pattern
        int[] lps = buildLPS(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return true; // Pattern found
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false; // Pattern not found
    }

    // Build the Longest Prefix Suffix (LPS) array for the pattern
    private static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        System.out.println(areRotations("abcd", "cdab")); // true
        System.out.println(areRotations("aab", "aba"));   // true
        System.out.println(areRotations("abcd", "acbd")); // false
        System.out.println(areRotations("aaa", "aaa"));   // true
        System.out.println(areRotations("abcd", "abcd")); // true
        System.out.println(areRotations("abcdefghij", "hijabcdefg")); // true
        System.out.println(areRotations("a".repeat(100000), "a".repeat(100000))); // true
        System.out.println(areRotations("a".repeat(100000), "b".repeat(100000))); // false
    }
    
}
