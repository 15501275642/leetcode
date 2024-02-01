//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1243 👎 0

package leetcode.editor.cn.数组;

import java.util.Arrays;

/**
 * 螺旋矩阵 II
 *
 * @author wangyanji
 * @date 2024-01-30 13:41:16
 */
public class 螺旋矩阵II {
    public static void main(String[] args) {
        Solution solution = new 螺旋矩阵II().new Solution();
        solution.generateMatrix(4);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            //循环的圈数
            int loop = 0;
            //每圈起始的点(start, start)
            int start = 0;
            //填充的数字
            int count = 1;
            //结果数组
            int[][] res = new int[n][n];
            int i , j;
            while (loop++ < n / 2) {
                //向右
                for (j = start; j < n - loop; j++) {
                    res[start][j] = count++;
                }
                //向下
                for (i = start; i < n - loop; i++) {
                    res[i][j] = count++;
                }
                //向左
                for (; j > start; j--) {
                    res[i][j] = count++;
                }
                //向上
                for (; i > start; i--) {
                    res[i][j] = count++;
                }
                start++;
            }
            //判断是否是奇数
            if (n % 2 == 1) {
                res[start][start] = count;
            }
            for (int[] re : res) {
                System.out.println(Arrays.toString(re) + "\n");
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}