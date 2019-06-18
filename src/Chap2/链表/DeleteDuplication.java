package Chap2.链表;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * */
public class DeleteDuplication {
    /**
     * 解题思路：
     *  还是链表中删除节点的思想，维持一个当前节点和它的前一个节点。遇到重复节点时，将前一个节点指向第一个不重复的节点。
     *
     *
     * 应该考虑的情况：
     *  1、开头是连续重复节点，即新链表的起始位置不是pHead
     *  2、所有节点相同，返回的是空
     *
     * 解决方法：
     *  创造一个新节点，将它作为起始节点，避免了头节点重复时起始点任意的情况。
     *  巧妙的用while（cur != null && cur.value == val）来跳过所有和cur相同的值，若全部相同，则新节点指向null(pre.next = null)
     *
     * */
    public static ListNode deleteDuplication(ListNode pHead) {

        //自己创建一个节点作为可靠节点
        ListNode first = new ListNode(0);
        //加在原来链表的前面
        first.next = pHead;
        //pre是当前节点的前一个节点，cur是原来链表的当前节点用来遍历链表
        ListNode pre = first;
        ListNode cur = pHead;

        while (cur != null && cur.next != null) {
            //前后两个节点相同时
            if (cur.value == cur.next.value) {
                int val = cur.value; //值记录下来
                //向后找，直到发现节点值不同的节点
                while (cur != null && cur.value == val)
                    cur = cur.next;
                pre.next = cur; //前一个节点（即first节点）指向这个不同值节点
                //若节点全为1，结束while后 pre.next = cur = null;
            }
            //前后两个节点不相等时，前一个节点和当前节点向后移动
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(1);
        pHead.next.next = new ListNode(1);
        pHead.next.next.next = new ListNode(1);
        pHead.next.next.next.next = new ListNode(1);
        pHead.next.next.next.next.next = new ListNode(1);
        pHead.next.next.next.next.next.next= new ListNode(1);


        while (deleteDuplication(pHead) != null){
            System.out.print(pHead.value + " ");
            pHead = pHead.next;
        }

    }
}
