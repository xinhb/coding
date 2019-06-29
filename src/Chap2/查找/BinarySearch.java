package Chap2.查找;
/**二分查找*/
public class BinarySearch {

    /**
     * @param arr 排序数组
     * @param target 目标数字
     * @return 目标数字在数组中的位置
     * */
    public static int binarySearch(int[] arr,int target) {
        int left = 0;
        int right = arr.length -1;
        int mid =0;
        while (right >= left){
            mid = (left + right)/2;
            if (arr[mid] == target)
                return mid;
            else if (target > arr[mid]) //目标元素大于中间元素，去右边区间找
                left = mid +1;   //[mid +1,right]
            else
                right = mid-1;
        }
        return -1; //target不在数组中
    }

    /**递归实现二分查找
     *
     * 存在一个问题，target不存在时栈会溢出。
     * */
    public static int binarySearch1(int[] arr,int l,int r,int target){

        int mid = (l+r)/2;  //每次进入递归重新计算中间位置
        if (l > r) return -1;

        if (arr[mid] == target && r >= l) { //r >= l不加效果一样
            return mid;
        }
        else if (target > arr[mid] )
             return binarySearch1(arr, mid + 1, r, target);
        else
             return binarySearch1(arr, l, mid - 1, target);
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 7, 8};
        System.out.println(binarySearch1(arr,0,arr.length-1,9));
    }
}
