package Chap2.两个栈实现队列;

import java.util.Stack;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 *  题目定义好了两个栈，明显是用两个栈来实现队列的功能（先进先出）
 *  很容易想到，将一个栈中的数字倒腾到另外一个栈中，就可以让最早入栈的数子跑到另外一个栈的栈顶了
 * */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**入队,直接放到stack1中*/
    public void push(int node) {
        stack1.push(node);

    }
    /**出队,先判断stack2中有没有，有的话直接pop出来，没有的话将stack1中的加到stack2中*/
    public int pop() {
        //这个判断有必要，可能队列中没有数子
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        //栈2为空，就需要去栈1中拿
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
            //栈2有数字，直接出栈
            return stack2.pop();
    }
}