package Chap2.替换空格;

/**
 * 有两个排序数组A1 和A2,内存在A1的末尾有足够的空间容纳A2
 * 请实现一个函数，把A2中的所有数字插入A1中，并且所有数字是排序的
 *
 * */
public class MergeArray {

    public int[] mergeArr(int[] A1, int[] A2 ,int length) {

        for (int i = 0; i < A2.length; i--) {
            int aim = A2[i];
            int index = 0;
            for (int j = length - 1; j >= 0; j--) {
                if (aim >= A1[j]) {

                }
                if (A1[j] < aim) {
                    index = j;
                    break;
                }else {}
            }
            //移位操作
            for (int k = length - 1; k > aim; k--) {
                A1[k + 1] = A1[k];
            }
            A1[++index] = aim;

        }
        return A1;
    }
    public static void main(String[] args) {
        int[] A1 = new int[10];
        for (int a =1,i = 0; i < 4; i ++,a += 2) {
            A1[i] = a;
        }
        int[] A2 = {2, 5};

    }

}
