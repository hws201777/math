package cn.hws.l;

import java.util.LinkedList;

public class N239 {

    //滑动窗口

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        LinkedList<Integer> list = new LinkedList<>();
        int[] data = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[i] >= nums[list.peekLast()]) {
                list.pollLast();
            }
            list.add(i);
            if (list.peekFirst() <= i - k) {
                list.poll();
            }
            if (i + 1 >= k) {
                data[i - k + 1] = list.peekFirst();
            }
        }
        return data;

    }
}
