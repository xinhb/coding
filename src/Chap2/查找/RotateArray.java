package Chap2.查找;

/*
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称为旋转数组。输入一个递增排序数组的一个旋转数组，输出旋转数组的最小元素。
* 例如，数组{3,4,5,1,2} 为{1,2,3,4,5}的一个旋转，该数组的最小值为1
* */
public class RotateArray {

    /**
     * 暴力解决：直接找数组中最小值
     *  时间复杂度为0(n)
     * */
    public static int findMinInArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }
    /*
    * 题目为啥要提出旋转数组这个概念，我们可以如何利用它？能有更好的解法吗？
    *   旋转数组是有序数组的变形，特点是前面一部分有序，后面一部分也有序。且前面一部分都比后面一部分要大。
    *   可以发现最小元素在前一部分的最大值之后，且后一部分的第一数字。
    *
    * 解题思路：
    *   结合旋转数组的特点，定义头尾两个指针。然后缩小这个区间就能找到最小值
    *   缩小规则：取中间值，若中间值 大于 头指针处的值，头向中间缩进；若中间值 小于 尾指针处的值，尾向中间缩进。
    *
    *   即：中间大于头，头换到中间。中间小于尾，尾换到中间。区间长度为2时，第二个数就是最小的
    *
    * 补充：
    *   1、旋转数组是是排序数组自身，即没有发生旋转。
    *       尾不再小于头了，判断尾大于头，数组返回arr[head]
    *
    *   2、旋转数组的头、尾、中间 都相同。
    *       二分法失效，采用顺序查找
    *
    * 实例分析：
    *    旋转数组：{3,4,5,1,2}
    *    1、头3，尾2，中5  （中间大于头）
    *    2、头5，尾2，中1  （中间小于尾）
    *    3、头5，尾1      （区间长度为2,结束）
    *
    * 提升一下：
    *   二分查找的本质是减少查找次数，将查找区间不断缩小，不要局限于只能是对半缩小这种情况。
    * */
    public static int findMinInArray1(int[] arr) {

         int head = 0;
         int tail = arr.length-1;
         /**<h2>旋转数组是本身</h2>*/
         if (arr[head] < arr[tail])
             return arr[head];

         int mid = (head+tail)/2;

         //二分法失效，只能顺序查找
         if (arr[mid]== arr[head] && arr[mid] == arr[tail])
             return findMinInArray(arr);
         else {  //可以用二分法查找
             while ((tail - head) > 2) {
                 if (arr[mid] > arr[tail]){ //中间大于头
                     head = mid;
                     mid = (head+tail)/2;
                 }
                 if (arr[mid] < arr[tail]){ //中间小于尾
                     tail = mid;
                     mid = (head+tail)/2;
                 }
             }
             return arr[tail];
         }
    }
    public static void main(String[] args) {

        int[] arr = {1,0,1,1,1};
        System.out.println(findMinInArray(arr));
        System.out.println("---------------");
        System.out.println(findMinInArray1(arr));
    }
}
