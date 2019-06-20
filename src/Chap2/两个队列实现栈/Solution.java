package Chap2.两个队列实现栈;

import java.util.LinkedList;

/**
 * 用两个队列来实现一个栈，即{1,2,3,4,5,6} 输出{6,5,4,3,2,1}
 *
 * 思路：先模拟入栈操作：队列1中入队了1,2,3 ，其中队列的头是1，尾是3。想要想栈一样先把3拿出来，就需要将1,2,转移到另一个队列里。
 *                      即每次保证出栈的那个队列只有一个数字。
 *      模拟出栈操作：1、2从队列头留到了队列2中，从队列1中拿去数字1。队列1就是空的了，下次从队列2中出栈。
 *
 *    即：把非空队列的n-1个压入空队列中，剩下的第n个出队。。。即总有一个队列为空
 * */
public class Solution {

    //定义两个队列
    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> quene2 = new LinkedList<>();

    public void push(int value) //入栈
    {
        queue1.addLast(value);
    }
    /**出栈必备，判断栈不为空,才能有出栈操作*/
    public int pop()  //出栈，必须是非空的栈才可以出栈
    {
        if (sSize() != 0){
            //判断哪个队列为空
            if (!queue1.isEmpty()) //队列1不为空，将它前面n-1个数移到队列2中
            {
                putN_1ToAnother();
                return queue1.removeFirst();
            }else {
                putN_1ToAnother();
                return quene2.removeFirst();
            }
        }else {
            System.out.println("栈已经为空啦，不能出栈");
            return -1;
        }
    }
    /**将非空队里的n-1个数移到另一个队列中，队里总是一空一非空*/
    private void putN_1ToAnother() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                quene2.addLast(queue1.removeFirst());
            }
        } else if (!quene2.isEmpty()) {
            while (quene2.size() > 1) {
                queue1.addLast(quene2.removeFirst());
            }
        }
    }
    /*栈中元素个数*/
    public int sSize(){
        return queue1.size() + quene2.size();
    }

    public static void main(String[] args)
    {
        Solution stack=new Solution();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());  //这一次栈穿了
    }

}
