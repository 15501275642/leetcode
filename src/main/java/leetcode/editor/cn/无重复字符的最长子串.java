//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 7878 👎 0

package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 *
 * @author wangyanji
 * @date 2022-07-25 10:50:04
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution solution = new 无重复字符的最长子串().new Solution();
        String s = "dvdf";
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //最大长度
            int max = 0, p2 = 0;
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                //判断余下的长度小于等于max break
                if (s.length() - i <= max) {
                    break;
                }

                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }
                //判断不包含
                while (p2 < s.length() && !set.contains(s.charAt(p2))) {
                    set.add(s.charAt(p2));
                    p2++;
                }
                int curCount = p2 - i;
                if (curCount > max) {
                    max = curCount;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


