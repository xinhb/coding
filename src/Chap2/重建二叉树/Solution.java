package Chap2.重建二叉树;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * */

public class Solution {

    /**定义二叉树*/
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    /**
     * 1、需要对二叉树遍历特点非常理解，知道，前序遍历：根数--左子树对应的子序列--右子树对应的子序列
     * 中序遍历：左子树--根--右子树、后序遍历：左子树--右子树--根
     * 所以通过根可以将中序遍历分离出左右子树。(必须知道中序遍历，且节点值不重复)
     *
     * 2、分解问题，发现子问题和父问题相同，用递归解决它。
     * */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        TreeNode root = findRootNode(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root; //返回树的根节点
    }
    /**
     * @param pre 前序序列
     * @param preStart 前序序列的起始点
     * @param preEnd  前序序列的重点
     * @param in 中序序列
     * @param inStart 中序序列起点
     * @param inEnd 中序序列终点
     *
     * 难点是在中序序列中找根节点的位置，并维护左右子树的数组范围。
     *
     * */
    private TreeNode findRootNode(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        for (int i = inStart; i <= inEnd; i ++) {
            if (in[i] == rootVal) {
                /**
                 * 找到中序遍历根节点的位置i,得到左子树长度为i-inStart,
                 * 所以左子树的前序遍历区间[preStar+1,perStar+i-inStart]，中序遍历区间[inStart,i-1]
                 * 右子树的前序遍历区间[preStart+i-inStart+1,preEnd],中序遍历区间[i+1,inEnd]
                 * */
                //左子树
                root.left = findRootNode(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                //右子树
                root.right = findRootNode(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
            }
        }
        return root;
    }
}
