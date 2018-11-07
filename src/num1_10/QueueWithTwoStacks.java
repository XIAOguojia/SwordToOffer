package num1_10;

import java.util.Stack;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/7
 * Time:20:46
 * 面试题9：用两个栈实现队列
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
 * 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class QueueWithTwoStacks<T> {

    Stack<T> stack1;
    Stack<T> stack2;
    public QueueWithTwoStacks(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public QueueWithTwoStacks(Stack<T> stack1, Stack<T> stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    public void appendTail(T node){
        stack1.push(node);
    }

    public T deleteHead(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size() == 0){
            try {
                throw new Exception("Quene is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<String> queue = new QueueWithTwoStacks();
        queue.appendTail("a");
        queue.appendTail("b");
        queue.appendTail("c");

        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

        queue.appendTail("d");
    }
}
