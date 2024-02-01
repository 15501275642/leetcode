//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
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
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1387 👎 0

package leetcode.editor.cn.二叉树;

/**
 * 翻转二叉树
 *
 * @author wangyanji
 * @date 2022-08-19 18:58:15
 */
public class 翻转二叉树{
    public static void main(String[] args) {
        Solution solution = new 翻转二叉树().new Solution();
        TreeNode t1 = new TreeNode(2, new TreeNode(1,null, null),new TreeNode(3,null, null));
        TreeNode t2 = new TreeNode(7, new TreeNode(6,null, null),new TreeNode(9,null, null));

        TreeNode root = new TreeNode(4, t1, t2);

    }
//leetcode submit region begin(Prohibit modification and deletion)
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}