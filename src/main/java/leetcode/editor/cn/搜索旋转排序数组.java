//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2371 👎 0

package leetcode.editor.cn;

/**
 * 搜索旋转排序数组
 *
 * @author wangyanji
 * @date 2022-10-28 09:52:04
 */
public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        //0,1,2,2,4,5,6,7,8,9
        //8,9,0,1,2,4,5,6,7
        int[] p = {8, 9, 0, 1, 2, 4, 5, 6, 7};

        Solution solution = new Solution();
        int search = solution.search(p, 4);
        System.out.println(search);

        //问题
        //在数组的任意位置一分为二之后, 一定有一边是有序, 一边无序
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int search(int[] nums, int target) {
            //数组为空直接返回找不到
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int length = nums.length;
            int l = 0;
            int r = length - 1;
            //左侧坐标比右侧坐标小就继续循环
            while (l <= r) {
                int midIndex = (l + r) / 2;
                //取数据中点
                if (nums[midIndex] == target) {
                    return midIndex;
                }
                int mid = nums[midIndex];
                //判断左侧有序, 还是右侧有序
                if (nums[0] <= mid) {
                    //判断目标值是否在左侧区间
                    if (nums[l] <= target && target <= mid) {
                        r = midIndex - 1;
                    } else {
                        l = midIndex + 1;
                    }
                } else {
                    //判断目标值是否在左侧区间
                    if (mid <= target && target <= nums[r]) {
                        l = midIndex + 1;
                    } else {
                        r = midIndex - 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}