//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2807 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author wangyanji
 * @date 2022-08-15 13:27:08
 */
public class 括号生成 {
    public static void main(String[] args) {
        Solution solution = new 括号生成().new Solution();
        List<String> strings = solution.generateParenthesis(2);
        System.out.println();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        List<String> list = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            resolve("", n, n);
            return list;
        }

        private void resolve(String s, int left, int right) {
            if (left == 0 && right == 0) {
                list.add(s);
                return;
            }
            if (left == right) {
                //剩余左右括号数相等，下一个只能用左括号
                resolve(s + "(", left - 1, right);
            } else {
                //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
                if(left > 0){
                    resolve(s+"(",left-1,right);
                }
                resolve(s+")",left,right-1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


