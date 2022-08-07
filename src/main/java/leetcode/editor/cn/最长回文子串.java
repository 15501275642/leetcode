//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5491 👎 0

package leetcode.editor.cn;

/**
 * 最长回文子串
 *
 * @author wangyanji
 * @date 2022-07-25 13:06:45
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        Solution solution = new 最长回文子串().new Solution();
        String s = "ab";
        String s1 = solution.longestPalindrome(s);
        System.out.println();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            // 判断s的长度是否小于2
            int l = s.length();
            if (s.length() < 2) {
                return s;
            }
            int begin = 0, max = 1;
            char[] chars = s.toCharArray();
            //定义二维数组
            boolean[][] dep = new boolean[l][l];
            //将长度为1的子串赋值为true
            for (int i = 0; i < l; i++) {
                dep[i][i] = true;
            }
            //填充列
            for (int j = 1; j < l; j++) {
                for (int i = 0; i < j; i++) {
                    //判断i 和 j 上的值是否相等
                    if (chars[i] != chars[j]) {
                        //不相等, 直接为false
                        dep[i][j] = false;
                    } else {
                        //相等
                        //判断 j - i 小于三
                        if (j - i < 3) {
                            dep[i][j] = true;
                        } else {
                            //判断左下角的值是否为true
                            dep[i][j] = dep[i + 1][j - 1];
                        }
                    }
                    //i 到 j 存在回文子串
                    // 判断是否比max大
                    //大 记录起始坐标和长度
                    if (dep[i][j] &&
                            j - i + 1 > max) {
                        begin = i;
                        max = j - i + 1;
                    }
                }
            }
            //返回
            return s.substring(begin, begin + max);
        }
    }
//leeshu'xiangmit region end(Prohibit modification and deletion)

}


