import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static final int MAX_CHAR = 26;

    // Function to generate hash of word s
    static String getHash(String s) {
        StringBuilder hash = new StringBuilder();
        int[] freq = new int[MAX_CHAR];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Append the frequency to construct the hash
        for (int i = 0; i < MAX_CHAR; i++) {
            hash.append(freq[i]);
            hash.append("$");
        }

        return hash.toString();
    }

    static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String key = getHash(arr[i]);

            // If key is not present in the hash map, add
            // an empty group (List) in the result and
            // store the index of the group in hash map
            if (!mp.containsKey(key)) {
                mp.put(key, res.size());
                res.add(new ArrayList<>());
            }

            // Insert the string in its correct group
            res.get(mp.get(key)).add(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        // Input array of strings
        String[] words = {"bat", "tab", "cat", "act", "rat", "tar", "art"};

        // Group the anagrams
        ArrayList<ArrayList<String>> groupedAnagrams = anagrams(words);

        // Print the grouped anagrams
        for (ArrayList<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}