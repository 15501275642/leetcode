//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 1076 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author wangyanji
 * @date 2023-10-10 17:03:47
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        Solution solution = new 杨辉三角().new Solution();
        solution.generate(5);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        list.add(1);
                    } else {
                        //取上一行集合
                        List<Integer> lastRow = res.get(i - 1);
                        list.add(lastRow.get(j - 1) + lastRow.get(j));
                    }
                }
                res.add(list);
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}