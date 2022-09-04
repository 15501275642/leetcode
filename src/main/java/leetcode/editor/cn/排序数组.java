//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 644 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 排序数组
 *
 * @author wangyanji
 * @date 2022-08-13 13:18:38
 */
public class 排序数组 {
    public static void main(String[] args) {
        Solution solution = new 排序数组().new Solution();
        int[] ints = solution.sortArray(new int[]{6, 5, 8, 7});
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return nums;
            }
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSort(int[] arr, int left, int right) {
            if (left > right) {
                return;
            }
            int i = left, j = right;
            int target = arr[left];
            while (i < j) {
                while (arr[j] >= target && i < j) {
                    j--;
                }
                while (arr[i] <= target && i < j) {
                    i++;
                }
                if (i < j) {
                    swap(arr, i, j);
                }
            }
            swap(arr, i, left);
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);

        }

        /**
         * 数组的两个坐标交换
         */
        private void swap(int[] arr, int left, int right) {
            int tep = arr[left];
            arr[left] = arr[right];
            arr[right] = tep;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


