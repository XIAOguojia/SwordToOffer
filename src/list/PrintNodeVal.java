package list;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/3/14
 * Time:22:22
 * 输入一个链表，从尾到头打印链表每个节点的值
 */
public class PrintNodeVal {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        System.out.println(printListFromTailToHead2(listNode).toString());
    }

    /**
     * 利用栈先入后出的特性
     * */
    private static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> s = new Stack<>();
        while (listNode != null){
            s.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!s.isEmpty()){
            arrayList.add(s.pop());
        }

        return arrayList;
    }

    /**
     * 递归法
     */
    static ArrayList<Integer> arrayList = new ArrayList<>();

    private static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead1(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

}
