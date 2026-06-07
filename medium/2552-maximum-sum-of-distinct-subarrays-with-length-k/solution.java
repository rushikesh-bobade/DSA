class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0;
        long ans = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        if (freq.size() == k) {
            ans = sum;
        }

        // Slide the window
        for (int right = k; right < nums.length; right++) {

            int left = right - k;

            // Remove left element
            sum -= nums[left];

            freq.put(nums[left], freq.get(nums[left]) - 1);

            if (freq.get(nums[left]) == 0) {
                freq.remove(nums[left]);
            }

            // Add new right element
            sum += nums[right];

            freq.put(nums[right],
                    freq.getOrDefault(nums[right], 0) + 1);

            // Check validity
            if (freq.size() == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}