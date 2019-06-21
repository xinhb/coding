package Chap2.循环与递归;

/**
 * 求 1+2+3+...+n
 */
public class AddForm1Ton {

    /*递归实现
    * fun(n) 表示1到n的和，则fun(n-1)代表1到n-1和，那么 fun(n) = fun(n-1) + n
    * */
    public static int function(int n) {
        //递归结束条件 .即 fun(0) = 0
        if (n == 0)
            return 0;

        return function(n-1) + n;
    }
    /**循环实现*/
    public static int function1(int n) {
        int result = 0;
        //从1 加到 n
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
    public static void main(String[] args) {
        /**
         * n越大递归越耗时，还会有栈溢出的风险。而用循环就不会，只有考虑返回值的可承受的范围
         * */
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            function(20000);
        }
        long end = System.currentTimeMillis();
        System.out.println("递归执行时间：" +(end-start));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++)
            function1(20000);
        long end2 = System.currentTimeMillis();
        System.out.println("循环执行时间：" +(end2-start2));
    }
}
