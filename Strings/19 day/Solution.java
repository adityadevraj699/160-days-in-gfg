public class Solution{
    public static int minChar(String s) {
        // Reverse the string
        String rev = new StringBuilder(s).reverse().toString();
        // Create the concatenated string
        String combined = s + "$" + rev;

        // Compute the LPS array
        int n = combined.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (combined.charAt(i) == combined.charAt(len)) {
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

        // Minimum characters to add = length of original string - longest palindromic prefix
        return s.length() - lps[n - 1];
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "abc";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + minChar(s1)); // Output: 2

        String s2 = "aacecaaaa";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + minChar(s2)); // Output: 2

        String s3 = "abcd";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + minChar(s3)); // Output: 3

        String s4 = "racecar";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + minChar(s4)); // Output: 0
    }
}
