package num1_10;


import java.util.Stack;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/6
 * Time:20:25
 * 面试题6：从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class PrintListInReversedOrder {
    public static void main(String[] args) {
        PrintListInReversedOrder p = new PrintListInReversedOrder();
        p.Test1();
        p.Test2();
        p.Test3();
    }

    /**
     * 递归法
     *
     * @param head 头指针
     */
    public void PrintListReversingly_Recursively(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                PrintListReversingly_Iteratively(head.next);
            }
            System.out.print(head.val+" ");
        }
    }

    /**
     * 利用栈先入后出的特性
     */
    public void PrintListReversingly_Iteratively(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    // ====================测试代码====================
    public void Test(ListNode pHead)
    {
        PrintList(pHead);
        System.out.println();
        PrintListReversingly_Iteratively(pHead);
        System.out.println();
        PrintListReversingly_Recursively(pHead);
        System.out.println();
    }

    private void PrintList(ListNode pHead) {
        ListNode tmp = pHead;
        while (tmp!=null){
            System.out.print(tmp.val+" ");
            tmp = tmp.next;
        }
    }

    // 1->2->3->4->5
    public void Test1()
    {
        System.out.println("Test1 begins.");

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        Test(listNode);
    }

    // 只有一个结点的链表: 1
    public void Test2()
    {
        System.out.println("Test2 begins.");

        ListNode listNode = new ListNode(1);

        Test(listNode);
    }

    // 空链表
    public void Test3()
    {
        System.out.println("Test3 begins.");
        Test(null);
    }
}
