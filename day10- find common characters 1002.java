class Solution {
    public List<String> commonChars(String[] words) {

        int[] minFreq = new int[26];

        // Initialize with frequency of first word
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }

        // Compare with remaining words
        for (int i = 1; i < words.length; i++) {

            int[] freq = new int[26];

            for (char c : words[i].toCharArray()) {
                freq[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], freq[j]);
            }
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                ans.add(String.valueOf((char)(i + 'a')));
                minFreq[i]--;
            }
        }

        return ans;
    }
}
