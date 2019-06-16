package Chap2.二维数组中查找;

/**
 *测试if..else 与if if 区别:
 * 最大的区别是，if...else if...else 只会选择满足条件的执行
 * 而if...if...if 每个if都会执行，并且会影响下一句if执行
 * */
public class Test {

    public static void ifIf(int num1) {
        if (num1 > 5) {
            num1 -=5;
            System.out.println("I am > 5");
        }
        if (num1 < 5) {

            System.out.println("I am < 5");
        }
        if (num1 == 5) {
            System.out.println("I am = 5");
        }
    }
    public static void ifElse(int num) {

        if (num > 5) {
            num -=5;
            System.out.println("I am 大于5");
        } else if (num  < 5) {

            System.out.println("I am 小于5");
        } else {
            System.out.println("I am 等于5");
        }
    }
    public static void main(String[] args) {
        ifIf(6);
        System.out.println("下面是if..else if ...else");
        ifElse(6);
    }
}
