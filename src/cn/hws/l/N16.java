package cn.hws.l;

import java.util.Arrays;

public class N16 {
    /**
     * 16. 最接近的三数之和
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 10^3
     * -10^3 <= nums[i] <= 10^3
     * -10^4 <= target <= 10^4
     */

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[right] + nums[left];
                if(sum == target) return sum;

                boolean flag = Math.abs(target - res) < Math.abs(target - sum);
                res = flag ? res : sum;
                if(target - sum > 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

}
