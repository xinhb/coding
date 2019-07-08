package Chap2.链表;


/**
 * <h2>删除链表中的某个节点</h2>
 * */
public class DeleteNode {
    /**
     * 常规做法：
     *  拿到要删除节点的前一个节点,在查找上花了0(n)的时间复杂度
     *
     * @param  pHead 链表的头结点
     * @param  pToBeDeleted 链表中要删除的节点
     * */
    public static void deleteNode(ListNode pHead, ListNode pToBeDeleted) {

        ListNode pre = pHead;              // 前一个节点
        ListNode curNode = pHead;          //当前节点

        //找到要删的节点
        while (curNode != pToBeDeleted) {
            pre = curNode;                 //记录被删节点的前节点
            curNode = curNode.next;
        }
        ListNode aimNode = curNode.next;   //目标节点
        pre.next = aimNode;                //前节点指向目标节点
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

    public static void deleteNode1(ListNode pHead, ListNode pToBeDeleted) {

        if (pHead == null || pToBeDeleted == null)
            return;
        //如果链表只有一个节点且是删除节点
        if (pHead == pToBeDeleted && pHead.next == null) {
            pHead =null;
        }

        ListNode pNext = pToBeDeleted.next;
        ListNode pNextNext = pNext.next;
        pToBeDeleted.value = pNext.value;

        pToBeDeleted.next = pNextNext; //要删节点指向下下个节点
    }
}
