package Chap2.不修改数组找重复数字;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 在长度为n+1的数组里的所有数字都是1~n的范围，所以数组中至少有一个数字是重复的。请找出数组中任意重复的数字，但不能修改输入数组。
 * 例如，输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应输出的重复数2或3。
 * */
public class Solution {

    /**
     * 不能修改数组，想到用辅助空间（数组或者哈希表）
     * 用ArrayList存下所用重复的数字
     * */
    public ArrayList<Integer> getDuplication1(int numbers[],int length){

        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (!hashSet.add(numbers[i])) {
                list.add(numbers[i]);
            }
        }
        return list;
    }
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arrs ={2,3,5,4,3,2,6,7};
        System.out.println(solution.getDuplication(arrs,8));
        System.out.println(solution.getDuplication1(arrs,8));
    }

    /**
     * 教科书级别解法：不用额外空间，而是时间换空间，时间复杂度O(nlogn)
     * 难点：对1到n数字用二分查找思想
     * 数组长度是n+1,而数字是1到n,则必存在某段数字区间内的数字个数大于区间长度，例如：[1,4]中的数字在原数组中出现5次
     * 再分成[1,2]和[3,4]区间，比较count与区间长度，直到区间长度为1，就可得到某个数字在数组中出现的次数。
     * @param numbers 原数组，数字是1~length-1
     * @param length 数组的长度
     * */
    public int getDuplication(int[] numbers, int length) {
        //假设数组长度为8，数字范围1~7
        int start = 1;
        int end = length - 1;

        while (end >= start) {
            int mid = (start + end)/2;
            //计算[1,4]区间内的原数组中数字个数
            int count = countRange(numbers, length, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            //大于区间长度，就[1,4]区间接着分,否则在[5,7]中找
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    /**
     * 统计某个[start,end]区间内的数字在数组numbers中出现的次数
     * @param numbers 原数组
     * @param length 数组长度
     * @param start 参照区间的左界
     * @param end 参照区间的右界
     * */
    private int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null)
            return 0;

        int count = 0;
        for (int i = 0; i < length; i++) {
            //[start,end]是连续数字
            if (numbers[i] >= start && numbers[i] <= end)
                count ++;
        }
        return count;
    }
}
