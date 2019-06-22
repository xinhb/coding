package Chap2.循环与递归;

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

        if (n < 2)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);

        //使用三目运算符，一句话搞定
        // return n < 2  ? n : Fibonacci(n - 1) + Fibonacci(n - 2);
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


    /**
     * 还有人说尾递归，和动态规划也可以实现
     * */

}
