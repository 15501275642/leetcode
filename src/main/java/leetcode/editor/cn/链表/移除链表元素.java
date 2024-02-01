//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1385 👎 0

package leetcode.editor.cn.链表;

import javax.swing.event.ListDataEvent;

/**
 * 移除链表元素
 *
 * @author wangyanji
 * @date 2024-01-30 17:25:42
 */
public class 移除链表元素 {
    public static void main(String[] args) {
        Solution solution = new 移除链表元素().new Solution();
        ListNode l7 = new ListNode(6);
        ListNode l6 = new ListNode(5, l7);
        ListNode l5 = new ListNode(4, l6);
        ListNode l4 = new ListNode(3, l5);
        ListNode l3 = new ListNode(6, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        solution.removeElements(l1, 6);

    }
//leetcode submit region begin(Prohibit modification and deletion)

    public static class ListNode {
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
        /**
         *  虚拟头节点的方式
         *  还有一种方式是先保证头节点不为空, while循环知道head不等目标值并且head不等于空
         * @param head 头节点
         * @param val 要删除的目标值
         * @return 删除完之后的链表
         */
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode res = new ListNode(-1, head);
            ListNode pre = res;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val == val) {
                    //执行删除操作
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}