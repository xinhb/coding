package Chap2.从尾打印链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * */
public class Solution {

    /**节点定义*/
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 前提是不改变链表结构的情况，也就是不能将链表反转
     * 利用栈的特性，先进后出。将链表从头到尾放到栈中，再从栈顶将节点值依次拿出来。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        //创建栈
        Stack<Integer> stack = new Stack<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //创建数组
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (!stack.isEmpty()){ //判断栈是否为空
            arrayList.add(stack.pop());
        }

        return arrayList;
    }
    /**
     * 栈是用来模拟递归的，那么也可以用递归实现。
     * */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode){

        ArrayList<Integer> arrayList = new ArrayList<>();
        dropNodeToArrayList(arrayList,listNode);
        return arrayList;
    }

    private void dropNodeToArrayList(ArrayList<Integer> arrayList,ListNode listNode) {

        if (listNode == null)
            return;
        //注意节点是在递归结束之后add到ArrayList中的，若放在前面是顺序加入的
        dropNodeToArrayList(arrayList,listNode.next);
        arrayList.add(listNode.val);
    }
}

