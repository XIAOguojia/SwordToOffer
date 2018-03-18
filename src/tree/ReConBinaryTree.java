package tree;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/17
 * Time:22:16
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(reConstructBinaryTree(pre, in));
    }


    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //空树
        if (pre == null || in == null) {
            return null;
        }
        TreeNode treeNode = reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return treeNode;

    }

    private static TreeNode reConstructBinaryTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode tree = new TreeNode(pre[preStart]);
        tree.left = null;
        tree.right = null;
        if (preStart == preEnd && inStart == inEnd) {
            return tree;
        }
        //找到根节点在中序遍历中的位置，然后区分左右子树
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                break;
            }
        }
        //左子树长度
        int leftlength = i - preStart;
        //右子树长度
        int rightlegth = inEnd - i;

        if (leftlength > 0) {
            tree.left = reConstructBinaryTree(pre, in, preStart + 1, preStart + leftlength, inStart, i - 1);
        }
        if (rightlegth > 0) {
            tree.right = reConstructBinaryTree(pre, in, leftlength + 1 + preStart, preEnd, i + 1, inEnd);
        }
        return tree;
    }


}
