//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1181 👎 0

package leetcode.editor.cn.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author wangyanji
 * @date 2022-08-19 16:44:48
 */
public class 螺旋矩阵{
    public static void main(String[] args) {
        Solution solution = new 螺旋矩阵().new Solution();
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,2,3,4};
        matrix[1] = new int[]{5,6,7,8};
        matrix[2] = new int[]{9,10,11,12};
        List<Integer> integers = solution.spiralOrder(matrix);
        System.out.println(integers);

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return new ArrayList<>();
        }
        //左右
        int l = 0, r = matrix[0].length,
        //上下
            t = 0, b = matrix.length;
        //结果数量
        int resultSize = r * b;
        List<Integer> resultList = new ArrayList<>();
        //起始坐标, 从0, 0开始走
        int lIndex = 0, wIndex = 0;
        while (resultList.size() < resultSize) {
            //右
            while (walk(l, r, t, b, lIndex, wIndex)) {
                resultList.add(matrix[lIndex][wIndex++]);
            }
            t ++; lIndex ++; wIndex--;
            //下
            while (walk(l, r, t, b, lIndex, wIndex)) {
                resultList.add(matrix[lIndex++][wIndex]);
            }
            r --; wIndex --; lIndex--;
            //左
            while (walk(l, r, t, b, lIndex, wIndex)) {
                resultList.add(matrix[lIndex][wIndex--]);
            }
            b --; lIndex --; wIndex++;
            //上
            while (walk(l, r, t, b, lIndex, wIndex)) {
                resultList.add(matrix[lIndex--][wIndex]);
            }
            l ++; wIndex++; lIndex ++;
        }
        return resultList;
    }

    private boolean walk (int l, int r, int t, int b,int lIndex, int wIndex) {
        //判断当前坐标是否可以打印
        return lIndex >= t &&
                lIndex < b &&
                wIndex >= l &&
                wIndex < r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}