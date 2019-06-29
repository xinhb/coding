package DP.整数拆分;

import java.util.Arrays;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 实例 3：
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 1、没有头绪，先想暴力解决。分割次数没有给定，很难用循环方式。
 * 2、考虑递归，发现是回溯算法
 * */
class Solution {
    /**
     *递归实现：
     *
     *分析：
     * 正整数 n ，拆分一次时，前一段长度为 1，2..n-2,n-1 后一段为n-1, n-2 ,....2,1 。
     * 当n=1时无法拆分，返回它的长度1；n >=2时，乘积的最大值是i*f(n-i)结果集中的最大值(0 < i < n)
     *
     * */
    public int integerBreak(int n) {

        //从2开始才能拆分，但是1作为递归结束条件
        if (n ==1) return 1;

        int res = -1; //保存子问的最优解
        for (int i = 1; i < n; i++) {
            //注意此处还要比较，分成两段的情况，即 i*(n-i)  而i * integerBreak(n - i)是继续往下分的情况
            res = max3(res, i*(n-i),i * integerBreak(n - i));
        }
       return res;
    }
    /**比较三个数大小*/
    private static int max3(int res, int a, int b) {
        return Math.max(Math.max(res, a), b);
    }

    /**
     * 中间重复计算太多，integerBreak(n - i)中有大量重复子问题，可以改成记忆化搜索
     */
    public static int integerBreak2(int n) {
        //从2开始才能拆分，但是1作为递归结束条件
        if (n ==1) return 1;

        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);

        if (memo[n]==-1){
            //meno[n]存放最优解
            for (int i = 1; i < n; i++) {
                //注意此处还要比较，分成两段的情况，即 i*(n-i)  而i * integerBreak(n - i)是继续往下分的情况
                memo[n] = max3(memo[n], i*(n-i),i * integerBreak2(n - i));
            }
        }
        return memo[n];
    }
    /**
     * 最好的解法是，基于正向递推的 动态规划
     * */
    public static int integerBreak3(int n) {

        if (n == 1) return 1;

        //定义数组存储子问题最优解，即 n = 1,2,3...n 的结果
        int[] memo = new int[n+1];
        memo[1] = 1;
        int res = -1;

        //双重for循环,动态规划的一般表达式
        for (int i = 2; i <= n; i++) { //外层是要计算的数n
            for (int j = 1; j < i; j++) { //内层找到子问题中的最大值，放入memo[i]中
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak2(10));
    }
}