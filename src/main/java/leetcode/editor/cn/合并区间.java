//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 1605 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 *
 * @author wangyanji
 * @date 2022-08-15 11:26:00
 */
public class 合并区间 {
    public static void main(String[] args) {
        Solution solution = new 合并区间().new Solution();
        int[][] a = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}};
        int[][] merge = solution.merge(a);
        System.out.println();
    }

    /**
     *
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            //判断数组的长度是否等于0
            if (intervals.length == 0) {
                return new int[0][];
            }
            //排序
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            //声明结果集
            List<int[]> list = new ArrayList<>();
            //循环遍历intervals
            for (int[] i : intervals) {
                //左, 右, 结果集长度
                int l = i[0], r = i[1], size = list.size();
                //结果集新增一组数据 判断声明结果是否为
                if (size == 0 || list.get(size - 1)[1] < l) {
                    list.add(i);
                }
                // 加入结果集最后一组数据的末尾区间
                else {
                    list.get(size - 1)[1] = Math.max(list.get(size - 1)[1], r);
                }
            }
            //返回结果集
            return list.toArray(new int[list.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

