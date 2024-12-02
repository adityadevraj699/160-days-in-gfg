import java.util.ArrayList;

class Solution {

    // Function to search all occurrences of 'pat' in 'txt'
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length(); // Length of the pattern
        int n = txt.length(); // Length of the text

        // Step 1: Compute the LPS (Longest Prefix Suffix) array
        int[] lps = computeLPS(pat);

        // Step 2: Use KMP algorithm to search the pattern in the text
        int i = 0; // Pointer for txt
        int j = 0; // Pointer for pat

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                // Pattern found, add starting index to result
                result.add(i - j);
                j = lps[j - 1]; // Reset j using LPS array
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS to avoid redundant comparisons
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    // Helper function to compute the LPS array
    private int[] computeLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        // Build the LPS array
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Avoid resetting i
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String txt1 = "abcab";
        String pat1 = "ab";
        System.out.println(solution.search(pat1, txt1)); // Output: [0, 3]

        String txt2 = "abesdu";
        String pat2 = "edu";
        System.out.println(solution.search(pat2, txt2)); // Output: []

        String txt3 = "aabaacaadaabaaba";
        String pat3 = "aaba";
        System.out.println(solution.search(pat3, txt3)); // Output: [0, 9, 12]
    }
}
