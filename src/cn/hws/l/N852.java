package cn.hws.l;

public class N852 {
    /**
     * 852. 山脉数组的峰顶索引
     * 我们把符合下列属性的数组 A 称作山脉：
     * <p>
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[0,1,0]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：[0,2,1,0]
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 3 <= A.length <= 10000
     * 0 <= A[i] <= 10^6
     * A 是如上定义的山脉
     */

    public int peakIndexInMountainArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] > nums[left - 1] && nums[left] < nums[left + 1]) {
                    return left;
                }
                left = mid + 1;
            } else if (nums[left] > nums[mid]) {
                if (nums[right] > nums[right - 1] && nums[right] < nums[right + 1]) {
                    return right;
                }
                right = mid - 1;
            }
        }
        return -1;
    }
}
