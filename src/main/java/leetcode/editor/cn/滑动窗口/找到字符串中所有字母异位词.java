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
            int sLen = s.length();
            int pLen = p.length();
            if (sLen < pLen) {
                return ans;
            }
            //建立两个数组存放字符串中字母出现的词频，并以此作为标准比较
            int[] scount = new int[26];
            int[] pcount = new int[26];
            //当滑动窗口的首位在s[0]处时 （相当于放置滑动窗口进入数组）
            for (int i = 0; i < pLen; i++) {
                ++scount[s.charAt(i) - 'a']; //记录s中前pLen个字母的词频
                ++pcount[p.charAt(i) - 'a']; //记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
            }
            //判断放置处是否有异位词     (在放置时只需判断一次)
            if (Arrays.equals(scount, pcount)) {
                ans.add(0);
            }
            //开始让窗口进行滑动
            for (int i = 0; i < sLen - pLen; i++) { //i是滑动前的首位
                --scount[s.charAt(i) - 'a'];       //将滑动前首位的词频删去
                ++scount[s.charAt(i + pLen) - 'a'];  //增加滑动后最后一位的词频（以此达到滑动的效果）

                //判断滑动后处，是否有异位词
                if (Arrays.equals(scount, pcount)) {
                    ans.add(i + 1);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
