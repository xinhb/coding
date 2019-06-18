package Chap2.链表;

/**
 * <h1>节点定义</h1>
 * 定义链表的一个节点,包含两个成员变量。一个是存放数值，另一个是指向下一个节点。
 * 若当前节点的next为null(即this.next == null)则该节点是最后一个节点
 * */
public class ListNode {

    int value;
    ListNode next = null;

    ListNode(int value) {
        this.value = value;
    }

    /**
     * <h2>删除链表中某个节点</h2>
     * 要拿到被删除节点的前一个节点，然后获取被删除节点的后一个节点，跳过删除节点，指向下一个节点。
     */
    public void removeNext() {
        /**假设要删除的是当前节点的下一个节点
         * 即this.next 节点要被删除
         * */
        ListNode nextNode = this.next.next; //拿到被删除节点的下一个节点
        this.next = nextNode; //当前节点直接指向被删节点的下一个节点
    }

    /**
     * <h2>插入节点</h2>
     * 在当前节点后面插入一个节点，需要先拿到当前节点的下一个节点
     */
    public void after(ListNode node) {
        //拿到当前节点的下一个节点
        ListNode Next = this.next;
        //新节点node插入
        this.next = node;
        node.next = Next;
    }
}

