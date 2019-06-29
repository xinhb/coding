package random;
/**
 * <h1>小和问题</h1>
 * 一个数组中，每个数左边比当前数小的数累加起来，叫做这个数组的小和，求一个数组的小和。
 *
 * 例如：[1,3,4,2,5]
 * 1左边没有比它小
 * 3左边比3小 1
 * 4左边比4小 1，3
 * 2左边比2小 1
 * 5左边比5小 1，3，4，2
 *
 * */
public class Solution {

    /**
     * 暴力法：去当前元素与前面的比较，小就累加起来。
     * 时间复杂度：0（n*n)
     * */
    public static int minSum(int[] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            for (int j = i; j >= 0; j--) {
                if (arr[j] < cur)
                    sum += arr[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(minSum(arr));
    }
}
