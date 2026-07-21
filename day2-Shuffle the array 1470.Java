class Solution {
    public int[] shuffle(int[] nums, int n) {

        // Create a new array to store the shuffled result
        int[] result = new int[2 * n];

        // Points to the next position in the result array
        int index = 0;

        // Loop through the first half of nums
        for (int i = 0; i < n; i++) {

            // Add x_i
            result[index] = nums[i];
            index++;

            // Add y_i
            result[index] = nums[i + n];
            index++;
        }

        // Return the shuffled array
        return result;
    }
}
