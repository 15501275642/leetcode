package leetcode.editor.cn.common;

/**
 * @description:
 * @author: wangyanji
 * @date: 2022/07/25/16:39
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
