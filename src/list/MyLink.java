package list;


/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/5/23
 * Time:22:38
 */
public class MyLink {
    /**
     * 头结点
     */
    Node head = null;

    class Node {
        //节点对象，即内容
        int data;
        //节点对象的引用，指向下一个节点
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 向链表中插入数据
     *
     * @param data
     */
    public void addNode(int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node pNode = head;
            while (pNode.next != null) {
                pNode = pNode.next;
            }
            pNode.next = newNode;
        }
    }

    /**
     * @param index 删除第index个节点
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > NodeLength()) {
            return false;
        }

        if (index == 1) {
            head = head.next;
            return true;
        }

        int i = 2;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = preNode.next;
            i++;
        }

        return false;

    }

    /**
     * @return 返回链表的长度
     */
    public int NodeLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 在不知道头结点的情况下，删除指定的节点
     *
     * @param node
     * @return
     */
    public boolean deleteNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        int temp = node.data;
        node.data = node.next.data;
        node.next.data = temp;
        node.next = node.next.next;
        System.out.println("删除成功");
        return true;
    }

    /**
     * 从头到尾打印列表
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MyLink link = new MyLink();
        link.addNode(3);
        link.addNode(4);
        link.addNode(5);
        link.addNode(6);
        link.addNode(7);
        link.addNode(8);
        System.out.println("head=" + link.head.data);
        link.printList();
        System.out.println("length=" + link.NodeLength());
        link.deleteNode(4);
        link.printList();


    }

    /**
     * 链表反转
     *
     * @param head
     * @return
     */
    public Node ReverseIteratively(Node head) {
        Node pReverseHead = null;
        Node pNode = head;
        Node pPre = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReverseHead = pNode;
            }
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;

        }
        this.head = pReverseHead;
        return this.head;
    }

    /**
     * 查找链表的中间值，快指针走两步，慢指针走一步
     *
     * @param head
     * @return
     */
    public Node SearchMid(Node head) {
        Node p = head, q = head;
        while (p != null && p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        System.out.println("Mid=" + q.data);
        return q;
    }

    /**
     * 查找倒数第K个元素
     *
     * @param head
     * @param k
     * @return
     */
    public Node SearchKValue(Node head, int k) {
        Node p = head, q = head;
        if (k < 1 || k > this.NodeLength()) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    /**
     * 链表排序，从小到大，冒泡排序
     *
     * @return
     */
    public Node orderList() {
        Node nextNode = null;
        int temp = 0;
        Node curNode = head;
        while (curNode != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.data > nextNode.data) {
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 删除重复的节点
     *
     * @param head
     */
    public void deleteDuplicate(Node head) {
        Node p = head;
        while (p != null) {
            Node q = p;
            while (q.next != null) {
                if (q.data == q.next.data) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    /**
     * 从尾到头打印链表，采用递归方式
     *
     * @param head
     */
    public void printReverseList(Node head) {
        while (head != null) {
            printReverseList(head.next);
            System.out.println(head.data);
        }
    }

    /**
     * 判断链表是否有环，单向链表有环时，尾节点相同
     *
     * @param head
     * @return
     */
    public boolean IsLoop(Node head) {
        Node fast = head, slow = head;
        if (fast == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("该链表有环");
                return true;
            }
        }

        return !(fast == null);
    }

    /**
     * 寻找链表环的入口
     *
     * @param head
     * @return
     */
    public Node findLoopPort(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}


