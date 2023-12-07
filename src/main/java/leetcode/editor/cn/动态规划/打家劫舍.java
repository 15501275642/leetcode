//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 2804 👎 0

package leetcode.editor.cn.动态规划;

import java.util.Arrays;
import java.util.Objects;

/**
 * 打家劫舍
 *
 * @author wangyanji
 * @date 2023-10-10 17:30:34
 */
public class 打家劫舍 {
    public static void main(String[] args) {
        Solution solution = new 打家劫舍().new Solution();
        int[] ints = {1, 2, 3, 1};
        solution.robMine(ints);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }

            int[] dp = new int[length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                //当前的两种方案
                //偷当前房子 结果为: 当前房子的钱 + (当前房子 - 2的最大值)
                //不偷当前房子 结果为 当前房子前一个的最大值之前的最大值
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[length - 1];
        }

        /**
         * https://leetcode.cn/problems/house-robber/solutions/28242/da-jia-jie-she-dong-tai-gui-hua-jie-gou-hua-si-lu-/?envType=study-plan-v2&envId=top-100-liked
         *
         * @param nums
         * @return
         */
        public int robKrahets(int[] nums) {
            //之前所有房子偷的最大值
            int pre = 0,
                    //当前所有房间最大值
                    cur = 0,
                    //临时变量用于给pre赋值
                    tmp;
            for (int num : nums) {
                tmp = cur;
                cur = Math.max(pre + num, cur);
                pre = tmp;
            }
            return cur;
        }


        public int robMine(int[] nums) {
            if (Objects.isNull(nums) || nums.length == 0) {
                return 0;
            }

            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            System.out.println(Arrays.toString(dp));
            return dp[dp.length - 1];
        }

    }

}