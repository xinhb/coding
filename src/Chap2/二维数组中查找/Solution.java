package Chap2.二维数组中查找;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * */
public class Solution {
    /**
     * 初级解法：
     *  暴力，遍历二维数组所有数字与target比较
     * @param target 要找的数字，
     * @param array 二维数组
     * @return 二维数组中存在目标数字返回true
     * */
    public boolean Find(int target, int [][] array) {
        int hang = array.length;
        int lie = array[0].length; //列数

        for(int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 教课书解法：充分利用行与列的有序性
     * 暴力解法，是选择从左上方数字开始与target比较，而巧解是从右上方（或左下方）数字开始
     * 因为右上角数字是当前行中最大的，同时是当前列最小的。每次与targetb比较就可以剔除一行或一列，大大缩小了范围
     * */
    public static boolean Find1(int target, int [][] array) {
        int hang = array.length;
        int lie = array[0].length; //列数

        //其实位置右上方
        int i = 0;   //行
        int j = lie - 1; //列

        while (i < hang && j >= 0) {
            if (array[i][j] > target){
                j --;
            }
            else if (array[i][j] <target){
                i ++;
            }
            else{ //即 array[i][j] == target
                return true;
            }
        }
        return false;
    }
    /**
     * 存在数组越界问题，右下角的6大于5,当前列被剔除。j为-1了，在下面的行判断中越界了。
     * 所以在下面的if判断中加上 j >=0 判断
     *
     *  while (i < hang && j >= 0) {
     *             if (array[i][j] == target)
     *                 return true;
     *             if (array[i][j] > target)
     *                 j --;  //j列不要
     *             if (j >= 0 && array[i][j] < target)
     *                 i ++; //i行不要
     *         }
     *  if...else if... else 先判断 array[i][j]是大于、小于还是等于 target，在执行对应函数体。
     *  而if...if...if 是重上往下判断条件是够成立，而且上面的fi会影响下面的判断。例如我发现的数组越界
     * */

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find1(5,arr));
    }
}
