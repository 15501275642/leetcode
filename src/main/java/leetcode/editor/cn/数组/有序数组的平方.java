//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 955 👎 0

package leetcode.editor.cn.数组;

/**
 * 有序数组的平方
 *
 * @author wangyanji
 * @date 2024-01-29 16:46:40
 */
public class 有序数组的平方 {
    public static void main(String[] args) {
        Solution solution = new 有序数组的平方().new Solution();
        int[] nums = {-3, -2, 0, 1, 9};

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            int j = nums.length - 1;
            int[] newArr = new int[nums.length];
            while (l <= r) {
                if (nums[l] * nums[l] < nums[r] * nums[r]) {
                    newArr[j--] = nums[r] * nums[r--];
                } else {
                    newArr[j--] = nums[l] * nums[l++];
                }
            }
            return newArr;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}