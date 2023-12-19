package data_structure_algorithm.leetcode;

import java.util.Arrays;

public class _1991findMiddleIndex {

    public static class Solution1 {

        /**
         前缀和
         时间复杂度：O(N)
         空间复杂度：O(1)
         */
        public int findMiddleIndex(int[] nums) {
            // 计算数组左右元素的和
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            // 计算数组的前缀和
            int preSum = 0;
            sum -= nums[0];
            if (preSum == sum) return 0;
            for (int i = 0; i < nums.length - 1; i++) {
                preSum += nums[i];
                sum -= nums[i + 1];
                if (preSum == sum) {
                    return i + 1;
                }
            }
            return -1;
        }

    }



    public static class Solution2 {

        /**
         前缀和：左求和 * 2 + 中间索引值 = total
         时间复杂度：O(N)
         空间复杂度：O(1)
         */
        public int findMiddleIndex(int[] nums) {
            int total = Arrays.stream(nums).sum(), sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum * 2 + nums[i] == total) {
                    return i;
                }
                sum += nums[i];
            }
            return -1;
        }

    }

}
