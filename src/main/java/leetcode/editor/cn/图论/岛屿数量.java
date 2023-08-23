//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2266 👎 0

package leetcode.editor.cn.图论;

/**
 * 岛屿数量
 *
 * @author wangyanji
 * @date 2023-08-22 11:56:32
 */
public class 岛屿数量 {
    public static void main(String[] args) {
        Solution solution = new 岛屿数量().new Solution();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(solution.numIslands1(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 深度优先搜索
         */
        public int numIslands1(char[][] grid) {
            int ans = 0;
            //上下
            for (int i = 0; i < grid.length; i++) {
                //左右
                for (int y = 0; y < grid[i].length; y++) {
                    if (grid[i][y] == '1') {
                        dfs(i, y, grid);
                        ans++;
                    }
                }
            }
            return ans;
        }
        private void dfs(int i, int y, char[][] grid) {
            //判断上下左右是否越界
            int t = 0;
            int d = grid.length;
            int l = 0;
            int r = grid[0].length;
            if (i < t || i >= d || y < l || y >= r || grid[i][y] == '0') {
                return;
            }
            grid[i][y] = '0';
            dfs(i + 1, y, grid);
            dfs(i - 1, y, grid);
            dfs(i, y + 1, grid);
            dfs(i, y - 1, grid);
        }




    /**
     * 广度优先搜索
     */
    public int numIslands2(char[][] grid) {
        return 1;
    }

    /**
     * 并查集
     */
    public int numIslands3(char[][] grid) {
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}