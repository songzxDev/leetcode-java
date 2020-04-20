package org.songzxdev.leetcode.study.week01;
//给你一个整数数组 nums，请你将该数组升序排列。
//
//
//
//
//
//
// 示例 1：
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//
//
// 示例 2：
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// -50000 <= nums[i] <= 50000
//
//

public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        if (nums != null && nums.length > 1) {
            mergeSort(nums, 0, nums.length - 1);
        }
        return nums;
    }

    /**
     * 归并排序
     * @param array
     * @param left
     * @param right
     */
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int midd = (left + right) >> 1;
            mergeSort(array, left, midd);
            mergeSort(array, midd + 1, right);
            merge(array, left, midd, right);
        }
    }

    private static void merge(int[] array, int left, int midd, int right) {
        if (left < right) {
            int[] temp = new int[right - left + 1];
            int i = left, j = midd + 1, k = 0;
            while (i <= midd && j <= right) {
                temp[k++] = array[i] > array[j] ? array[j++] : array[i++];
            }
            while (i <= midd) {
                temp[k++] = array[i++];
            }
            while (j <= right) {
                temp[k++] = array[j++];
            }
            System.arraycopy(temp, 0, array, left, temp.length);
        }
    }
}
