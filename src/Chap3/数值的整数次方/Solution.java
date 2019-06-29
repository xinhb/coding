package Chap3.数值的整数次方;

/**
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * */
public class Solution {
    /**
     * 要我们求base的exponent次方。base是double类型，exponent是整型
     *
     * 难点在于：指数可能为负数，底数能为零的情况。写代码前可以想想测试用例,注意代码的完整性。
     * 三种输入：
     *  1、底数不为零，指数为正数。正常求解
     *  2、底数为零，指数为负数，没有意义。需要指明
     *  3、底数不为零，指数为负数。结果取倒数
     *
     * @param base 底数
     * @param exponent 指数
     * */
    public double Power(double base, int exponent) {

        if (base==0 && exponent < 0)
            return 0.0;  //代表非法输入
        if(exponent == 0) return 0;

        if (exponent >= 0) {
            return absPower(base,exponent);
        }else
            return 1/absPower(base,exponent);
    }

    private double absPower(double base, int exponent) {
        exponent = Math.abs(exponent);
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    /* 利用递归每次折半，提高指数运算效率
    *
    *   指数为偶数时，f(base,exponent/2)*f(base,exponent/2)
    *   指数为奇数时，f（base,exponet/2)*f(base,exponent/2)*base
    * */
    private double absQuickPower(double base, int exponent) {
        if (exponent==1)
            return base;
        double result = absQuickPower(base, exponent>>2);
        result *= result;
        if (exponent%2 ==1) //若指数是奇数，多乘一次base
            result *= base;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Power(2,0));

    }
}