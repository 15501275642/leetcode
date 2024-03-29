//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 5196 👎 0

package leetcode.editor.cn;

/**
 * 最大子数组和
 *
 * @author wangyanji
 * @date 2022-08-07 10:37:30
 */
public class 最大子数组和{
    public static void main(String[] args) {
        Solution solution = new 最大子数组和().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int preMax = 0,
                //就一个的话没有选
                max = nums[0];
        for (int a : nums) {
            //有你更好, 还是我自己更好
           preMax = Math.max(preMax + a, a);
           //走过这一路, 一直拿的最好的
           max = Math.max(preMax , max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


