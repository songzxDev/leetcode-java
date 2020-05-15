package org.songzxdev.leetcode.study.week02;

import java.util.Arrays;

public class LeetCode912 {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        return countSort(nums);
    }

    private int[] countSort(int[] nums) {
        int minNum = 0, maxNum = 0;
        for (int num : nums) {
            minNum = Math.min(num, minNum);
            maxNum = Math.max(num, maxNum);
        }
        final int countSize = maxNum - minNum + 1;
        int[] countArray = new int[countSize];
        for (int num : nums) {
            countArray[num - minNum]++;
        }
        for (int i = 1; i < countSize; i++) {
            countArray[i] += countArray[i - 1];
        }
        int[] copyArray = Arrays.copyOf(nums, nums.length);
        for (int f = nums.length - 1; f >= 0; f--) {
            int k = --countArray[copyArray[f] - minNum];
            nums[k] = copyArray[f];
        }
        return nums;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode912().sortArray(new int[] {5,3,9,10})));
    }
}
