package Chap2.数组中重复的数字;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * */

public class Solution {


    /**
     * 教课书级别的解法： 时间复杂度O(n)，空间复杂度O(1)
     * 比较巧妙的是，数组下标和数字都是0~n-1，若无重复数字则完美对应上,用移位大法将他们对应上
     * i与numbers[i]不相等时，将numbers[i]与下标j=numbers[i]比较，不相等将i与j处的数字交换（第一数字找到了它的位置）
     * 对交换来的数字在进行上面操作，直到i处的数字等于下标为j=numbers[i]的数字
     * */
    public boolean duplicate3(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        int i = 0;
        while (i < length) {
            if (i != numbers[i]) {
                if (numbers[i] != numbers[numbers[i]]) {
                    swap(numbers, i, numbers[i]);
                } else {
                    duplication[0] = numbers[i];
                    return true;
                }
            } else { //下标与值相等，移到下一位
                i ++;
            }
        }
        return false;
    }

    /**
     * 比较偷懒的方法用哈希表的特性来解题，重复元素是放不进去的，且返回false。
     * 时间复杂度可以控制在O(n),但用了额外的O(n)空间
     * @param numbers 带查找数组
     * @param length 数组长度，其实就是numbers.lenth
     * @param duplication 保存重复数字，第一个被找到的重复数字放在duplication[0]中
     * @return 存在重复元素返回true
     * */
    public boolean duplicate(int numbers[],int length,int [] duplication){

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!hashSet.add(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 还可以将原数组排好序，再比较相邻元素是否相等
     * 需要用到Arrays.sort()时间复杂度O(nlog(n))
     * */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        /**
         * 代码写得要严谨一点，对象为空或数组长度为0 ，是比较常见的判断
         * */
        if (numbers == null || length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int j) {

        int temp =numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
