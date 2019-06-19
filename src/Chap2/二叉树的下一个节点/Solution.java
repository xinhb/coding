package Chap2.二叉树的下一个节点;
/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * */
public class Solution {

    /**节点定义*/
    public class TreeLinkNode{
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     *  判断当前节点类型是关键
     *  1、当前节点的右孩子存在，就从右孩子出发，一直往左指到头就是下一个节点
     *
     *  2、当前节点不是根节点, 再判断若是父亲的左孩子，下个节点就是父亲
     * */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        //TreeLinkNode pNext = null;

        if (pNode == null) return null;

        //节点的右孩子存在，则设置指针从右孩子出发，直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
        if (pNode.right != null) {

            pNode= pNode.right; //当前节点的右孩子节点
            while (pNode.left != null)
                pNode = pNode.left;

            return pNode;
        }
        //当前节点不是根节点，判断它是不是父节点的左孩子，是就返回父节点。不是就继续遍历其父节点的父节点
        while(pNode.next!=null)
        {
            if(pNode.next.left == pNode) //pNode.next.left 父亲节点的左孩子节点
                return pNode.next; //当前节点的父亲节点

            pNode=pNode.next;  //找父亲的父亲节点
        }
        return null;

    }
}
