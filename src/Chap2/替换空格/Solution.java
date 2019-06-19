package Chap2.替换空格;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * */
public class Solution {

    /**
     * 用额外的空间，O(n)时间复杂度实现
     * */
    public static String replaceSpace(StringBuffer str) {

        //创建一个StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        int len = str.length();
        //将原来串移动到新串中
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return new String(stringBuffer);
    }
    /**
     * 不用额为的空间，就地扩容，然后原来的字符串从尾巴到头依次后移
     * 时间复杂度O(n) ,空间复杂度O(1)
     *
     * 特别注意：
     *  扩容时StringBuffer的长度在变化，不能像数组那样用str.length()遍历，而要先保存下来。
     *
     * */
    public static String replaceSpace1(StringBuffer str) {

        if (str == null)
            return null;

        int oldIndex = str.length() - 1; //保存原始长度

        //扩容原来的字符串
        for (int i = 0; i <= oldIndex; i++) {
            if (str.charAt(i) == ' ') {
                //增加空格数的两倍的容量
                str.append(' ');
                str.append(' ');
            }
        }
        //System.out.println(str.length());

        int newIndex = str.length() - 1;  //扩容后的长度
        for (int old = oldIndex; old >= 0; old --){
            //遇到空格
            if (str.charAt(old) == ' ') {
                str.setCharAt(newIndex --,'0');
                str.setCharAt(newIndex --,'2');
                str.setCharAt(newIndex --,'%');
                oldIndex --;
            }else {
                str.setCharAt(newIndex,str.charAt(old));
                newIndex --;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("");
        System.out.println(replaceSpace1(stringBuffer));


    }
}
