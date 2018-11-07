package num1_10;


/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/7
 * Time:17:16
 * 面试题8：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 */
public class NextNodeInBinaryTrees {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode parent = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        NextNodeInBinaryTrees node = new NextNodeInBinaryTrees();
        node.Test1_7();
        node.Test8_11();
        node.Test12_15();
        node.Test16();
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode pNext = null;
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            pNext = pRight;
        } else if (pNode.parent != null) {
            TreeLinkNode pParent = pNode.parent;
            TreeLinkNode pCurrent = pNode;
            while (pParent != null && pCurrent == pParent.right) {
                pCurrent = pParent;
                pParent = pParent.parent;
            }
            pNext = pParent;
        }
        return pNext;
    }

    // ==================== 辅助代码用来构建二叉树 ====================
    private TreeLinkNode CreateTreeLinkNode(int value) {
        TreeLinkNode node = new TreeLinkNode(value);
        return node;
    }

    private void ConnectTreeNodes(TreeLinkNode pParent, TreeLinkNode pLeft, TreeLinkNode pRight) {
        if (pParent != null) {
            pParent.left = pLeft;
            pParent.right = pRight;

            if (pLeft != null) {
                pLeft.parent = pParent;
            }
            if (pRight != null) {
                pRight.parent = pParent;
            }
        }
    }

    private void PrintTreeNode(TreeLinkNode pNode) {
        if (pNode != null) {
            System.out.println("Value of this node is:" + pNode.val);
            if (pNode.left != null) {
                System.out.println("Value of its left child is:" + pNode.left.val);
            } else {
                System.out.println("Left child is null.");
            }

            if (pNode.right != null) {
                System.out.println("Value of its right child is:" + pNode.right.val);
            } else {
                System.out.println("Right child is null");
            }
        } else {
            System.out.println("Node is null.");
        }
        System.out.println();
    }

    private void PrintTree(TreeLinkNode pRoot) {
        PrintTreeNode(pRoot);

        if (pRoot != null) {
            if (pRoot.left != null) {
                PrintTree(pRoot.left);
            }
            if (pRoot.right != null) {
                PrintTree(pRoot.right);
            }
        }
    }

    // ====================测试代码====================
    private void Test(String testName,TreeLinkNode pNode, TreeLinkNode expected)
    {
        if(testName != null){
            System.out.println("Begin "+testName);
        }

        TreeLinkNode pNext = GetNext(pNode);
        if(pNext == expected) {
            System.out.println("PASSED.");
        }else {
            System.out.println("FAILED");
        }

    }

    //            8
    //        6      10
    //       5 7    9  11
    void Test1_7()
    {
        TreeLinkNode pNode8 = CreateTreeLinkNode(8);
        TreeLinkNode pNode6 = CreateTreeLinkNode(6);
        TreeLinkNode pNode10 = CreateTreeLinkNode(10);
        TreeLinkNode pNode5 = CreateTreeLinkNode(5);
        TreeLinkNode pNode7 = CreateTreeLinkNode(7);
        TreeLinkNode pNode9 = CreateTreeLinkNode(9);
        TreeLinkNode pNode11 = CreateTreeLinkNode(11);

        ConnectTreeNodes(pNode8, pNode6, pNode10);
        ConnectTreeNodes(pNode6, pNode5, pNode7);
        ConnectTreeNodes(pNode10, pNode9, pNode11);

        Test("Test1", pNode8, pNode9);
        Test("Test2", pNode6, pNode7);
        Test("Test3", pNode10, pNode11);
        Test("Test4", pNode5, pNode6);
        Test("Test5", pNode7, pNode8);
        Test("Test6", pNode9, pNode10);
        Test("Test7", pNode11, null);

    }

    //            5
    //          4
    //        3
    //      2
    void Test8_11()
    {
        TreeLinkNode pNode5 = CreateTreeLinkNode(5);
        TreeLinkNode pNode4 = CreateTreeLinkNode(4);
        TreeLinkNode pNode3 = CreateTreeLinkNode(3);
        TreeLinkNode pNode2 = CreateTreeLinkNode(2);

        ConnectTreeNodes(pNode5, pNode4, null);
        ConnectTreeNodes(pNode4, pNode3, null);
        ConnectTreeNodes(pNode3, pNode2, null);

        Test("Test8", pNode5, null);
        Test("Test9", pNode4, pNode5);
        Test("Test10", pNode3, pNode4);
        Test("Test11", pNode2, pNode3);


    }

    //        2
//         3
//          4
//           5
    void Test12_15()
    {
        TreeLinkNode pNode2 = CreateTreeLinkNode(2);
        TreeLinkNode pNode3 = CreateTreeLinkNode(3);
        TreeLinkNode pNode4 = CreateTreeLinkNode(4);
        TreeLinkNode pNode5 = CreateTreeLinkNode(5);

        ConnectTreeNodes(pNode2, null, pNode3);
        ConnectTreeNodes(pNode3, null, pNode4);
        ConnectTreeNodes(pNode4, null, pNode5);

        Test("Test12", pNode5, null);
        Test("Test13", pNode4, pNode5);
        Test("Test14", pNode3, pNode4);
        Test("Test15", pNode2, pNode3);

    }

    void Test16()
    {
        TreeLinkNode pNode5 = CreateTreeLinkNode(5);

        Test("Test16", pNode5, null);

    }

}
