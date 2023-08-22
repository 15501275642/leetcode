package leetcode.editor.cn.滑动窗口;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1255 👎 0

import java.util.*;

public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        Solution solution = new 找到字符串中所有字母异位词().new Solution();
        String s = "cbaebabacd", p = "abc";
        List<Integer> anagrams = solution.findAnagrams(s, p);
        System.out.println(anagrams);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            char[] sArr = s.toCharArray();
            char[] pArr = p.toCharArray();

            if (sArr.length < pArr.length) {
                return ans;
            }
            int[] sCount = new int[26];
            int[] pCount = new int[26];

            for (int i = 0; i < pArr.length; i++) {
                sCount[sArr[i] - 'a']++;
                pCount[pArr[i] - 'a']++;
            }
            if (Arrays.equals(sCount, pCount)) {
                ans.add(0);
            }
            for (int i = 0; i < sArr.length - p.length(); i++) {
                sCount[sArr[i] - 'a']--;
                sCount[sArr[i + p.length()] - 'a']++;
                if (Arrays.equals(sCount, pCount)) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
