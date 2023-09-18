//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1670 👎 0

package leetcode.editor.cn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 课程表
 *
 * @author wangyanji
 * @date 2023-08-24 11:44:15
 */
public class 课程表 {
    public static void main1(String[] args) {
        Solution solution = new 课程表().new Solution();

    }



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        int []visit;
        boolean isValid = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            visit = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                list.add(new ArrayList<>());//初始化
            }
            for (int []info : prerequisites) {
                //学info[0]之前要先学info[1],所以info[1]指向info[0],
                //所以在info[1]的ArrayList中存储它指向哪个科目
                list.get(info[1]).add(info[0]);
            }
            for (int i = 0; i < numCourses; i++) {
                if (visit[i] == 0) {//如果是未搜索的科目，则深搜
                    dfs(i);
                }
            }
            return isValid;
        }

        public void dfs(int v) {
            visit[v] = 1;//标记该科目为搜索中
            for (int w : list.get(v)) {//遍历该科目指向的学科
                if (visit[w] == 0) {//如果指向的某一学科未搜索过，则深搜
                    dfs(w);
                    if (!isValid) {
                        return;
                    }
                } else if (visit[w] == 1) {//如果指向的某一学科在搜索中，则有环，标记isVaild
                    isValid = false;
                    return;
                }
            }
            visit[v] = 2;//因为该科目已经完成深搜，所以标记它的状态未搜索过
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}