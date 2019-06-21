package Chap2.循环与递归;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * */
public class RectCover {
    /**
     * 用实例去模拟这个过程，我们把2*8的覆盖方法记为f(8) ,按照覆盖规则“2*1的小矩形横着或竖着去覆盖”并没有限定个数。
     * 发现从f(7)竖着覆盖 或者 f(6)横着覆盖两个都可以得到f(8)
     *  即f(n) = f(n-1) + f(n-2) ???斐波那契额数列嘛
     * */
    public int rectCover(int target) {

        if (target <=0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        int a = 1;
        int b = 2;
        int c = 0;
        while (target > 2) {
            c = a + b;
            a = b;
            b = c;
            target --;
        }
        return c;
    }
}
