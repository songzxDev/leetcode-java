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

import java.util.Arrays;

public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        if (nums != null && nums.length > 1) {
//            mergeSort(nums, 0, nums.length - 1);
//            countSort(nums);
            quickSort(nums, 0, nums.length - 1);
        }
        return nums;
    }

    /**
     * 归并排序
     *
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

    /**
     * 计数排序
     *
     * @param array
     */
    private static void countSort(int[] array) {
        if (array != null && array.length > 1) {
            int minNum = 0, maxNum = 0, n = array.length;
            for (int num : array) {
                minNum = Math.min(minNum, num);
                maxNum = Math.max(maxNum, num);
            }
            int[] countArray = new int[maxNum - minNum + 1];
            for (int num : array) {
                countArray[num - minNum]++;
            }
            for (int i = 1; i < countArray.length; i++) {
                countArray[i] += countArray[i - 1];
            }
            int[] temp = Arrays.copyOf(array, n);
            for (int k = n - 1; k >= 0; k--) {
                int p = --countArray[temp[k] - minNum];
                array[p] = temp[k];
            }
        }
    }

    /**
     * 快速排序
     *
     * @param array
     * @param begin
     * @param end
     */
    private static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int pivot = partition(array, begin, end);
            quickSort(array, begin, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[i];
                array[i] = array[counter];
                array[counter++] = temp;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }
}
