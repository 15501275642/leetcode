//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 1747 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 *
 * @author wangyanji
 * @date 2022-08-15 00:51:34
 */
public class 子集 {
    public static void main(String[] args) {
        Solution solution = new 子集().new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            //添加空集合
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(new ArrayList<>());
            for (int num : nums) {
                int size = subsets.size();
                for (int j = 0; j < size; j++) {
                    //添加nums当前元素
                    List<Integer> sub = new ArrayList<>(subsets.get(j));
                    sub.add(num);
                    subsets.add(sub);
                }
            }
            return subsets;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}


