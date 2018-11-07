package num1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/7
 * Time:15:07
 * 面试题7：重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
 * 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
 * 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
 * 图2.6所示的二叉树并输出它的头结点。
 */
public class ConstructBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        constructBinaryTree.Test1();
        constructBinaryTree.Test2();
        constructBinaryTree.Test3();
        constructBinaryTree.Test4();
        constructBinaryTree.Test5();
        constructBinaryTree.Test6();
        constructBinaryTree.Test7();
    }

    public static TreeNode Construct(int[] preorder, int[] inorder, int length) {
        if (preorder == null || inorder == null || length <= 0) {
            return null;
        }
        return ConstuctCore(preorder, 0, length - 1, inorder, 0, length - 1);
    }

    private static TreeNode ConstuctCore(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = null;
        root.right = null;
        if (preStart == preEnd && inStart == inEnd && preorder[preStart] == inorder[inStart]) {
            return root;
        }
        //根节点位置
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new RuntimeException("输入的两个序列不匹配，这树有毒！");
        }

        //左子树长度
        int leftLength = index - inStart;
        //右子树长度
        int rightLength = inEnd - index;
        //把左子树和右子树分别作为新的二叉树，则可以求出其根节点，左子树和右子树。
        if (leftLength > 0) {
            root.left = ConstuctCore(preorder, preStart + 1, preStart + leftLength, inorder, inStart, index - 1);
        }
        if (rightLength > 0) {
            root.right = ConstuctCore(preorder, preStart + leftLength + 1, preEnd, inorder, index + 1, inEnd);
        }
        return root;
    }

    public void PrintInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        PrintInOrder(root.left);
        System.out.print(root.val + " ");
        PrintInOrder(root.right);
    }

    // ====================测试代码====================
    private void Test(String name, int[] preOrder, int[] inorder, int length) {
        if (name != null) {
            System.out.println("Begin " + name);
        }
        System.out.println("The preorder sequence is:");
        for (int i = 0; i < length; i++) {
            System.out.print(preOrder[i] + " ");
        }
        System.out.println();
        System.out.println("The inorder sequence is:");
        for (int i = 0; i < length; i++) {
            System.out.print(inorder[i] + " ");
        }
        System.out.println();
        TreeNode root = Construct(preOrder, inorder, length);
        PrintInOrder(root);
        System.out.println();
    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private void Test1() {
        final int length = 8;
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Test("Test1", preorder, inorder, length);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private void Test2() {
        final int length = 5;
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};

        Test("Test2", preorder, inorder, length);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private void Test3() {
        final int length = 5;
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};

        Test("Test3", preorder, inorder, length);
    }

    // 树中只有一个结点
    private void Test4() {
        final int length = 1;
        int[] preorder = {1};
        int[] inorder = {1};

        Test("Test4", preorder, inorder, length);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private void Test5() {
        final int length = 7;
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};

        Test("Test5", preorder, inorder, length);
    }

    // 输入空指针
    private void Test6() {
        Test("Test6", null, null, 0);
    }

    // 输入的两个序列不匹配
    private void Test7() {
        final int length = 7;
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};

        Test("Test7: for unmatched input", preorder, inorder, length);
    }
}




















