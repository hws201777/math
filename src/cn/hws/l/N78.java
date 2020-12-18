package cn.hws.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N78 {


    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        helper(nums, 0, true, tmp);
        tmp.remove(Integer.valueOf(nums[0]));
        helper(nums, 0, false, tmp);
        return res;
    }

    private static void helper(int[] nums, int index, boolean flag, List<Integer> tmp) {
        if(flag){
            tmp.add(nums[index]);
        }

        if (index == nums.length - 1) {
            List<Integer> tmp2 = new ArrayList<>();
            tmp2.addAll(tmp);
            res.add(tmp2);
            return;
        }

        index++;
        helper(nums,index,true,tmp);
        tmp.remove(Integer.valueOf(nums[index]));

        helper(nums,index,false,tmp);
    }

    public static void main(String[] args) {
        int[] p = {1, 2, 3};
        System.out.println(subsets(p));
    }

}
