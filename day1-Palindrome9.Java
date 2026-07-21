class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers are never palindromes
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;      // Get the last digit
            x = x / 10;              // Remove the last digit
            reversed = reversed * 10 + digit; // Build the reversed number
        }

        return original == reversed;
    }
}
