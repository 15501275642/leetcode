//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3438 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号
 *
 * @author wangyanji
 * @date 2022-08-06 21:22:32
 */
public class 有效的括号 {
    public static void main(String[] args) {
        Solution solution = new 有效的括号().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            //如果字符串的长度的为奇数个, 则返回false
            int length = s.length();
            if (length % 2 == 1) {
                return false;
            }
            Map<Character, Character> map = new HashMap<>(3);
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (stack.isEmpty() || !map.get(c).equals(stack.peek())) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


