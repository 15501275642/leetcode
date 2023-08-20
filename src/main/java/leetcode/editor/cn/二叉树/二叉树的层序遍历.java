//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
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
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1422 👎 0

package leetcode.editor.cn.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author wangyanji
 * @date 2022-08-12 22:18:01
 */
public class 二叉树的层序遍历 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的层序遍历().new Solution();
        solution.levelOrder(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)));
    }
//leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();;
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    if(left != null) {
                        queue.offer(left);
                    }
                    if(right != null) {
                        queue.offer(right);
                    }
                }
                if (list.size() > 0) {
                    result.add(list);
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


