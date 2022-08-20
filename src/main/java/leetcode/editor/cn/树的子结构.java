//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 给定的树 A: 
//
// 3 / \ 4 5 / \ 1 2 给定的树 B： 
//
// 4 / 1 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
//
// Related Topics 树 深度优先搜索 二叉树 👍 621 👎 0

package leetcode.editor.cn;

/**
 * 树的子结构
 *
 * @author wangyanji
 * @date 2022-08-20 10:54:22
 */
public class 树的子结构 {
    public static void main(String[] args) {
        Solution solution = new 树的子结构().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        /*
       参考:数据结构与算法的题解比较好懂
       死死记住isSubStructure()的定义:判断B是否为A的子结构
       */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {
                return false;
            }
            return
                    //A的根节点是B的根节点
                    recur(A, B) ||
                            //A的左结构包含B
                            isSubStructure(A.left, B) ||
                            //A的右结构包含B
                            isSubStructure(A.right, B);
        }

        private boolean recur(TreeNode A, TreeNode B) {
            //B走完了
            if (B == null) {
                return true;
            }
            //判断A是否为空 并且A的值是否和B的值相等
            if (A == null || A.val != B.val) {
                return false;
            }
            //相等继续判断, 直到B为空
            return recur(A.left, B.left) && recur(A.right, B.right);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}