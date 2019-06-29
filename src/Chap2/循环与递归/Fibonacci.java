package Chap2.循环与递归;

import java.util.Arrays;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *
 * n<=39
 * */
public class Fibonacci {

    /**
     * 解法一：递归实现
     * 先要知道斐波那契数列的特点：第一项为0 ，第二项为 1，从第三项起始前面两项的和
     * 所以状态定义一下：fib(n)->第n项的值， fib(n) = fib(n-1) + fib(n-2);
   * */
    public int fibonacci(int n) {

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);

        //使用三目运算符，一句话搞定
        // return n < 2  ? n : Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**记忆化搜索实现*/
    public static int fibonacci2(int n) {

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        //创建数组，并将初始值赋为-1
        int[] res = new int[n + 1];
        Arrays.fill(res,-1);

        //从n=2开始，将结果记录到res数组中，下次求解fib(n)时不会进入递归
        if (res[n] == -1) {
            res[n] = fibonacci2(n-1) + fibonacci2(n-2);
        }
        return res[n];
    }

    /*动态规划解法*/
    public static int fibonacci3(int n) {
        //数组中访问的下标小于0会越界
        if(n < 2) return n;

        int[] res = new int[n + 1];
        Arrays.fill(res,-1);

        res[0] = 0;
        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }


    /**
     * 解法二：
     * 知道了这种规律何不如用循环来，自下而上实现，从第一项推到第n项
     *
     * 看执行时间明显比递归要快很多
     * */
    public int fibonacci1(int n) {

        if (n < 2)
            return n;

        //定义的局部变量，要初始化
        int fibNMinusOne = 1; //第n项的前一项
        int fibNMinusTwo = 0; //第n项的前前一项
        int fibN = 0;

        for (int i = 2; i <= n; i++) {
            //变量的值转移
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci2(25));
    }

    /**
     * 还有人说尾递归，和动态规划也可以实现
     * */

}
