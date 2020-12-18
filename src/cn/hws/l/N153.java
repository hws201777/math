package cn.hws.l;

public class N153 {
    /**
     * 153. 寻找旋转排序数组中的最小值
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 请找出其中最小的元素。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2]
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 中的所有整数都是 唯一 的
     * nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转
     */
    public int search(int[] nums) {
        int mid;
        int left= 0;
        int right = nums.length-1;
        while(left<=right){

            if(nums[left] <= nums[right]){
                return nums[left];
            }
            mid = left + ((right-left)>>1);

            if(nums[left] <= nums[mid]){
                left = mid+1;
            }else if(nums[left] > nums[mid]){
                right = mid;
            }
        }
        return -1;
    }
}
