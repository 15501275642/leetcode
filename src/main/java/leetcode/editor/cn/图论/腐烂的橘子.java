//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 737 👎 0

package leetcode.editor.cn.图论;

import java.util.*;

/**
 * 腐烂的橘子
 *
 * @author wangyanji
 * @date 2023-08-22 15:13:20
 */
public class 腐烂的橘子 {
    public static void main(String[] args) {
        Solution solution = new 腐烂的橘子().new Solution();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int i = solution.orangesRotting1(grid);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dr,dc 配合使用得到 grid[r][c] 上grid[r-1][c]左grid[r][c-1]下grid[r+1][c]右grid[r][c+1]的元素
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        public int orangesRotting(int[][] grid) {
            // 获取二维数组的行数row 和 列数 column
            int R = grid.length, C = grid[0].length;
            // queue : all starting cells with rotten oranges
            Queue<Integer> queue = new ArrayDeque<>();
            Map<Integer, Integer> depth = new HashMap<>();
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    if (grid[r][c] == 2) {
                        int code = r * C + c;  // 转化为索引唯一的一维数组
                        queue.add(code); //存储腐烂橘子
                        depth.put(code, 0); //存储橘子变为腐烂时的时间,key为橘子的一维数组下标，value为变腐烂的时间
                    }
                }
            }

            int ans = 0;
            while (!queue.isEmpty()) {
                int code = queue.remove();
                int r = code / C, c = code % C;
                for (int k = 0; k < 4; ++k) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    //判断当前是否可以继续往下走
                    if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        int ncode = nr * C + nc;
                        queue.add(ncode);
                        // 计次的关键 元素 grid[r][c] 的上左下右元素得腐烂时间应该一致
                        depth.put(ncode, depth.get(code) + 1);
                        ans = depth.get(ncode);
                    }
                }
            }

            //检查grid，此时的grid能被感染已经都腐烂了，此时还新鲜的橘子无法被感染
            for (int[] row : grid) {
                for (int v : row) {
                    if (v == 1) {
                        return -1;
                    }
                }
            }
            return ans;

        }

        public int orangesRotting1(int[][] grid) {
            int[] dc = {-1, 1, 0, 0};
            int[] dr = {0, 0, -1, 1};

            //行的长度
            int R = grid.length;
            //列的长度
            int C = grid[0].length;

            //队列
            Queue<Integer> queue = new LinkedList<>();
            //Map
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    //查出所有腐烂的橘子
                    if (grid[i][j] == 2) {
                        int node = i * C + j;
                        queue.add(node);
                        map.put(node, 0);
                    }
                }
            }
            int ans = 0;
            //广度优先搜索
            while (!queue.isEmpty()) {
                Integer remove = queue.remove();
                int i = remove / C;
                int j = remove % C;
                for (int k = 0; k < 4; k++) {
                    //判断是否符合条件
                    int a = i + dr[k];
                    int b = j + dc[k];

                    if (a >= 0 && a < R && b >= 0 && b < C && grid[a][b] == 1) {
                        grid[a][b] = 2;
                        int tNode = a * C + b;
                        map.put(tNode, map.get(remove) + 1);
                        queue.add(tNode);
                        ans = map.get(tNode);
                    }

                }
                //上下左右进行搜索
            }
            //判断是否还有新鲜水果
            for (int[] g : grid) {
                for (int i : g) {
                    if (i == 1) {
                        return -1;
                    }
                }
            }
            return ans;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}