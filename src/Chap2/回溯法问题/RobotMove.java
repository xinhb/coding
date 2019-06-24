package Chap2.回溯法问题;
/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * */
public class RobotMove {
    /**
     * 读题：
     *  求解机器人能达到多少个格子，即求：从机器人的行走路径上都经过了哪些格子。
     *
     * 思考：
     *  题目对机器人能进入的格子有限制：行坐标可列坐标的位数之和不大于k
     *  我们的切入点就是这里，【找到机器人所能达到的最远方格，再判断它的周围格子是够也可以达到。】我理解的不对，这有点动态规划的意思。
     *  其实回溯法是比较傻的，它从二维数组的第0个格子（第一行，第一列）开始判断这个格子机器人是否可以进入，可以进入的话，用状态二维数组记下格子的状态。
     *  然后判断相邻的四个格子机器人是否也可以进入。
     *
     *  解题步骤：
     *  1、定义一个同样的方格，记录该方格机器人是否走过了。
     *  2、从起始点（0，0）判断机器人是否可以进入。可以进入，改变格子的状态。
     *  3、判断相邻的四个格子是否也可以进入。
     * */
    public int movingCount(int threshold, int rows, int cols) {  // 5,10,10 或 10,1,10

     
        //创建记录状态的数组
        boolean[] marked = new boolean[rows * cols];
        return move(0,0,threshold,rows,cols,marked);
    }
    /**
     * 递归方法，每到一个格子就四个方向搜索
     *
     * @param row 当前行
     * @param col 当前列
     * @param threshold 门限值
     * @param rows 总行数
     * @param cols 总列数
     * @param marked 是否访问过
     * @return 当前格子加四个方向能访问到的格子总数
     * */
    private int move(int row, int col, int threshold, int rows, int cols, boolean[] marked) {
        int count = 0;

        if (checked(row, col, threshold, rows, cols, marked)) { //判断当前格子可以进入
            marked[row * cols + col] = true;  //记下当前格子已经到达过

            //递归判断其它四个方向
            count = move(row - 1, col, threshold, rows, cols, marked) +
                    move(row + 1, col, threshold, rows, cols, marked) +
                    move(row , col - 1, threshold, rows, cols, marked) +
                    move(row , col + 1, threshold, rows, cols, marked) + 1;
        }
        return count;
    }
    /**
     * 判读格子是否超过门限值，已经边界判断
     *
     * 这里比较容易出错，没处理好会导致部分用例无法通过，报数组指针越界。或者就是用例全部无法通过。例如!marked[row * cols + col] 掉了 !
     * */
    private boolean checked(int row, int col, int threshold, int rows, int cols, boolean[] marked) {
        if (row >= 0 && row < rows && col >= 0 && col <cols && !marked[row * cols + col] && digitSum(row) + digitSum(col) <= threshold) {
            return true;
        }
        return false;
    }
    /**
     * 例如：123 每位相加的和返回 6
     * @param number 某个数字
     * @return 该数字的数位之和
     * */
    private int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
}