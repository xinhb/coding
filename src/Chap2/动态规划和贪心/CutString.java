package Chap2.动态规划和贪心;
/**
 * 给你一根长度为n的绳子，把绳子剪成m段（m、n都是整数且m > 1, n > 1）,m段绳子的长度依然是整数，求m段绳子的长度乘积最大为多少？
 * 比如绳子长度为8，我们可以分成2段、3段、4段...8段，只有分成3段且长度分别是2、3、3时能得到最大乘积18
 */
public class CutString {
    /**
     * 一、你怎么看出来的用动态规划解题？
     *  1、最优解问题
     *  2、子问题还是不停的切下去，也是求最优解
     *  3、子问题有重叠的小问题，例如：
     *  4、可以从上往下分析，从下往上求解
     * 完全满足这四个特点。
     *
     * 二、如何优雅的解出动态规划的问题？
     *  1、分析问题的能力（自上向下）
     *  2、抽象建模的能力，能定义出某个状态的数学式子
     *  3.将分析实际问题的逻辑，用自己定义的状态式表达出来，在此之上接着分析
     *  4、自下向上，写出代码
     *
     *  理论不代表你会，实操一下：
     * 一、案例分析
     *  读题：把一根长度为n米的绳子，剪成任意长度（1 ~ n-1米），随便多少段。求这些段段的乘积的最大值。
     *
     *  为了好分析，我们定义一个状态：f(n) 它表示长度为n米的绳子切成任意断后的乘积最大值。实际长度为n的绳子有 1到n-1 这n-1个切割点，最长段n-1米，最短段1米。
     *  在剪第一刀的时候，第一段长度可以为 1到n-1的任意值，那么第二段就为 n-1到1的任意值。记0 < i < n，则第一段长度为i，第二段为n-i ,他们的最大乘积对应f(i)和f(n-i)
     *  所以n米长的绳子剪一刀后两段最大值  max( f(i)*f(n-i) ) 0<i<n  即为 n米长绳子任意剪切的乘积的最大值 f(n)
     *
     *  有点分析不清楚，举个具体例子：n = 8时，f(8) = max( f(i)*f（8-i) ) 展开有四种情况：
     *  第一次子问题中的最大值
     *  f(1)*f(7)
     *  f(2)*f(6)
     *  f(3)*f(5)
     *  f(4)*f(4)   求这四种情况的最大值就是f(8)即长度为8米时最大值
     *
     *  我们发现f(1)= 1、但是f(7)不好求，f(7) = max(  f(i)*f(7-i) )，还要在子问题中求最大值。
     *  第二次求子问题最大值
     *  f(1)*f(6)
     *  f(2)*f(5)
     *  f(3)*f(4)
     *
     *
     *  此时f(8)的第一种情况就变成了f(1)*f(7) = 1 * f(1)*f(6) = 1*1*f(6) ,还需要再求下去
     *  f(1)*f(5)
     *  f(2)*f(4)
     *  f(3)*f(3)
     *
     *  f(1)*f(4)
     *  f(2)*f(3)
     *
     *  f(1)*f(3)
     *  f(2)*f(2)
     *
     *  f(1)*f(2)
     *
     *  可以看出了
     *  1、每次都要在子问题中找最大值，并且子问题中有大量重复的计算f()的值。即公共小问题的最优解。
     *  2、如果从上往下写代码，重复计算将非常恐怖。所以采用从下往上写代码实现，先求出小问题的最优解，并记录下来，提高给上层求解最优解使用。
     *
     *  动态规划可以规划最优解的人生：
     *      以结果（目标）为导向，将其分解成小的目标，如果还是太大不好实施接着分下去....
     *      将每件事情做好，利用好每一天，每天积累自己的最优解
     * */
    public static int maxProductAfterCutting(int length) {
        //突然发现两点最重要：1、定义状态，写出状态转移的数学表达式 2、判断子问题的最优解

        //f(n) = max( f(i)*f(n-i) )

        if ( length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        // 加1是因为需要访问到products[length]
        int[] products = new int[length + 1];

        // 下面这三个存的不是f(1)、f(2)、f(3)，只是单纯的长度而已
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        // 从products[4]到products[length]放的是f(4)~f(n)的值
        for (int i = 4; i <= length; i++) {

            int max = 0;
            for (int j = 1; j <= i / 2; j++) { //求出子问题f(i)的最大值，例如f(4)

                int product = products[j] * products[i - j]; //遍历子问题的所有解，得到最优解
                if (max < product)
                    max = product;
            }
            //得到子问题最优解,并存到数组中。不过最后加入的是当前问题的最优解即length
            products[i] = max;
        }
        return products[length];
    }
    /**
     * 贪婪法
     * 每一步都有一个最优解的选择（固定的），而不像动态规划那样，需要对比多个选择来得到最优解
     *
     * 实例分析：
     *  当n>5时，两个不等式成立 ：3*(n-3) > n ， 2*(n-2) > n，所以每一步要分出3来，无法分3再分2。
     *
     * 动态规划练好，贪婪可遇不可求，需要较强数学功底。
     * */
    public static int maxProductAfterCutting2(int length) {

        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int timesOf3 = length/3; //可以分成长度为3的段数

        //最后一段为4,需要回到前一段，将它分成 2*2 而不是 3*1
        if (length -timesOf3*3 == 1)
            timesOf3 --;
        // 长度为2的绳子段数
        int timesOf2 = (length - 3* timesOf3)/2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);

    }
    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting2(15));
    }
}
