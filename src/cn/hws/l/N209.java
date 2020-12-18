package cn.hws.l;

public class N209 {
    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */

    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int index = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                while (sum >= s) {
                    res = Math.min(i - index + 1, res);
                    sum -= nums[index];
                    index++;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
