//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2394 👎 0

package leetcode.editor.cn.二叉树;

/**
 * 二叉树的最近公共祖先
 *
 * @author wangyanji
 * @date 2023-08-14 15:52:32
 */
public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的最近公共祖先().new Solution();
        //[3,5,1,6,2,0,8,null,null,7,4]

        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t4 = new TreeNode(4, null, null);

        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t2 = new TreeNode(2, t7, t4);
        TreeNode t0 = new TreeNode(0, null, null);
        TreeNode t8 = new TreeNode(8, null, null);

        TreeNode t5 = new TreeNode(5, t6, t2);
        TreeNode t1 = new TreeNode(1, t0, t8);

        TreeNode t3 = new TreeNode(3, t5, t1);

        TreeNode l = t5;
        TreeNode r = t0;
        System.out.println("输入:" + l + " " + r);
        TreeNode treeNode = solution.lowestCommonAncestor(t3, l, r);
        System.out.println("输出:" + treeNode.val);

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        //公司技术部出了两个叛徒，技术部的每个小部门都有两个部门（二叉树）要找出他们的Line Manager
        //各单位开始排查，从基层员工查起，最后汇总，找第一个Line manager
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //没有查询目标
            if (root == null) {
                return null;
            }
            //从自己查起如果自己是叛徒, 就没有向下查的必要了, 要么我下边有另一个叛徒, 要么在其他事业线了, 我先主动上报, 别的事业线没查到就我背锅了
            if (root == p || root == q) {
                return root;
            }
            //向下级传递 在各层级团队找叛徒
            TreeNode first_traitor = lowestCommonAncestor(root.left, p, q);
            //向下级传递 在各层级团队找叛徒
            TreeNode second_traitor = lowestCommonAncestor(root.right, p, q);

            //我下边查出来两个叛徒, 那就是我了
            if (first_traitor != null && second_traitor != null) {
                return root;
            }
            //我们团队只找到一个叛徒，这个叛徒代表整个团队，就用这个叛徒来向上（回溯）提交甩锅
            //p.s. 太好了，跟我这个小manager没啥关系
            if (first_traitor != null) {
                return first_traitor;
            }
            if (second_traitor != null) {
                return second_traitor;
            }
            //我们是最干净的团队！
            return null;
        }


        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            //如果查询目标root为空, 那就不用查了, 没问题谁都不用走
            if (root == null) {
                return null;
            }
            //如果查询目标root就是p或者q那就查到了, 没有向下查的必要了,送我走!
            //因为要么我下边就是另一个叛徒, 那背锅的也是我, 谁叫我是他的上级
            //ps. 我现在期望的事别的事业线有叛徒, 我的领导不可能是叛徒, 因为他是的话, 就不会查到我了 呜呜呜
            if (root == p || root == q) {
                return root;
            }
            //哈哈, 不是我, 往下查, 希望我这帮下边的弟弟没有问题 祈祷ing
            //从左边查, 再让下边的继续向下查把背锅的给我查出来
            TreeNode first = lowestCommonAncestor1(root.left, p, q);
            //从右边边查, 再让下边的继续向下查把背锅的给我查出来
            TreeNode second = lowestCommonAncestor1(root.right, p, q);
            //看看左边和右边是不是都查出来人了都查出来就得把我报上去了 呜呜呜
            if (first != null && second != null) {
                return root;
            }
            //哈哈哈, 我下边可能就查出来一个或者没有噢, 问题不大哦, 我肯定不用我背锅了, 我看看是谁给它供出来

            //我看看左边
            if (first != null) {
                //逮到你了, 送走
                return first;
            }

            //我看看右边
            if (second != null) {
                //逮到你了, 送走
                return second;
            }

            return null;
            //哈哈哈哈 没有, 啥都没有
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}