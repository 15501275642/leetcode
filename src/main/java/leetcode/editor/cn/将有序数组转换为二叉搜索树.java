//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
// 
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
//
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 1112 👎 0

package leetcode.editor.cn;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author wangyanji
 * @date 2022-08-14 23:33:46
 */
public class 将有序数组转换为二叉搜索树{
    public static void main(String[] args) {
        Solution solution = new 将有序数组转换为二叉搜索树().new Solution();
         
    }
//leetcode submit region begin(Prohibit modification and deletion)

 public class TreeNode {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return resolve(nums, 0, nums.length - 1);
    }
    private TreeNode resolve (int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right)/2;
        mid = (right - left) /2 + left;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = resolve(nums, left, mid - 1);
        root.right = resolve(nums, mid + 1, right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


