//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 680 👎 0

package leetcode.editor.cn.二叉树;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author wangyanji
 * @date 2022-08-14 21:59:40
 */
public class 二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的锯齿形层序遍历().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            //定义开关 true代表从左到右 false取反
            boolean flag = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                Deque<Integer> deque = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (flag) {
                        deque.addLast(poll.val);
                    } else {
                        deque.addFirst(poll.val);
                    }
                    TreeNode left = poll.left, right = poll.right;
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                }
                //状态位取反
                flag = !flag;
                result.add(new LinkedList<>(deque));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


