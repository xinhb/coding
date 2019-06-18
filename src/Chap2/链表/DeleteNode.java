package Chap2.链表;


/**
 * <h2>删除链表中的某个节点</h2>
 * */
public class DeleteNode {
    /**
     * 常规做法：
     *  拿到要删除节点的前一个节点,在查找上花了0(n)的时间复杂度
     * */
    public void deleteNode(ListNode pHead, ListNode pToBeDeleted) {

        ListNode curNode = pHead;
        //拿到要删除节点的前一个节点
        while (curNode.next != pToBeDeleted) {
            curNode = curNode.next;
        }

        ListNode aimNode = curNode.next.next;
        curNode.next = aimNode;
    }

    /**
     * 教科书做法：“转嫁他人” 时间复杂度0(1),省去遍历链表的时间
     * 将要删除节点的value用它的下一个节点的value覆盖，然后删除下个节点
     *
     * 问题：
     *  若是被删节点是尾节点，仍需顺序查找，时间复杂度0(n)
     *  链表只有一个节点的情况
     *
     * @param pHead 链表的头指针
     * @param pToBeDeleted 要被删除的节点
     * */

    public void deleteNode1(ListNode pHead, ListNode pToBeDeleted) {

        if (pHead == null || pToBeDeleted == null)
            return;
        //如果链表只有一个节点且是删除节点
        if (pHead == pToBeDeleted && pHead.next == null) {
            pHead =null;
        }

        ListNode pDeletedNext = pToBeDeleted.next; //用值域覆盖被删节点的节点
        ListNode pAfter = pDeletedNext.next.next; //被删节点的下下个节点

        pToBeDeleted.value = pDeletedNext.value;
        pToBeDeleted.next = pAfter;
    }
}
