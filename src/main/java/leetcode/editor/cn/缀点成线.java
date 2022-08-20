//给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ，
// [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 
//输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates 中不含重复的点 
// 
//
// Related Topics 几何 数组 数学 👍 118 👎 0

package leetcode.editor.cn;

/**
 * 缀点成线
 *
 * @author wangyanji
 * @date 2022-08-19 22:39:47
 */
public class 缀点成线 {
    public static void main(String[] args) {
        Solution solution = new 缀点成线().new Solution();
        int[][] arr = new int[6][2];
        arr[0] = new int[]{1, 2};
        arr[1] = new int[]{2, 3};
        arr[2] = new int[]{3, 4};
        arr[3] = new int[]{4, 5};
        arr[4] = new int[]{5, 6};
        arr[5] = new int[]{7, 8};
        solution.checkStraightLine(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
            int n = coordinates.length;
            for (int i = 0; i < n; i++) {
                coordinates[i][0] -= deltaX;
                coordinates[i][1] -= deltaY;
            }
            int A = coordinates[1][1], B = -coordinates[1][0];
            for (int i = 2; i < n; i++) {
                int x = coordinates[i][0], y = coordinates[i][1];
                if (A * x + B * y != 0) {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}