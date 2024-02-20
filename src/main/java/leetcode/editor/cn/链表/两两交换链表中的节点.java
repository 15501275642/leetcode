//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1523 👎 0

package leetcode.editor.cn.链表;

/**
 * 两两交换链表中的节点
 *
 * @author wangyanji
 * @date 2022-08-19 18:24:49
 * 1.要有虚拟节点
 * 2.控制遍历的边界, 考虑链表个数 奇偶数
 */
public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        Solution solution = new 两两交换链表中的节点().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            //生成头结点
            ListNode hair = new ListNode(-1, head);
            ListNode cur = hair;
            while (cur.next != null && cur.next.next != null) {
                ListNode temp = cur.next;
                ListNode temp1 = cur.next.next.next;
                //交换
                cur.next = cur.next.next;
                cur.next.next = temp;
                //更新cur坐标
                temp.next = temp1;
                cur = cur.next.next;
            }
            return hair.next;
        }

        public ListNode swapPairs1(ListNode head) {
            //生成头结点
            ListNode hair = new ListNode(-1, head);
            //快指针走两步 慢指针走一步
            ListNode fast = hair, slow = hair;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                //交换slow的下一个节点和fast
                swap(fast, slow);
                fast = fast.next;
                slow = fast;
            }
            return hair.next;
        }

        private void swap(ListNode fast, ListNode slow) {
            ListNode temp = slow.next;
            slow.next = fast;
            temp.next = fast.next;
            fast.next = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}