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
        System.out.println();
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
            //判断左右下标
            if (left > right) {
                return;
            }
            //取数组第一个元素当中间值
            int index = arr[left];
            int i = left;
            int j = right - 1;
            while (i < j) {
                //从右向左找第一个比index小的数
                while (arr[j] >= index && i < j) {
                    j--;
                }
                //从左向右找第一个比index大的数
                while (arr[i] <= index && i < j) {
                    i++;
                }
                if (i < j) {
                    swap(arr, i, j);
                }
            }
            //将第一个位置的index和i做交换
            swap(arr, left, i);
            //调用当前index左边的左右边界
            quickSort(arr, left, i - 1);
            //调用当前index右边的左右边界
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


