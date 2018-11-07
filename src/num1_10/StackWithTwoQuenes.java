package num1_10;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/11/7
 * Time:21:02
 * 用两个队列实现栈
 */
public class StackWithTwoQuenes<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public StackWithTwoQuenes(){
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }


    public StackWithTwoQuenes(Queue<T> queue1, Queue<T> queue2) {
        this.queue1 = queue1;
        this.queue2 = queue2;
    }

    /**
     * 向栈中压入数据
     * @param element
     */
    public void push(T element){
        //两个队列都为空时，优先考虑 queue1
        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(element);
            return;
        }
        //如果queue1为空，queue2有数据，直接放入queue2
        if (queue1.isEmpty()){
            queue2.add(element);
            return;
        }
        //如果queue2为空，queue1有数据，直接放入queue1中
        if (queue2.isEmpty()){
            queue1.add(element);
            return;
        }
    }

    /**
     * 从栈中弹出一个数据
     * @return
     */
    public T pop(){
        //如果两个栈都为空，则没有元素可以弹出，异常
        if (queue1.isEmpty() && queue2.isEmpty()){
            try {
                throw new Exception("Stack is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //如果queue1中没有元素，queue2中有元素，将其queue2中的元素依次放入queue1中，
        // 直到最后一个元素，弹出即可
        if (queue1.isEmpty()){
            while (queue2.size() >1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }

        //如果queue2中没有元素，queue1中有元素，将其queue1中的元素依次放入queue2中，
        // 直到最后一个元素，弹出即可
        if (queue2.isEmpty()){
            while (queue1.size()>1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }

        return null;
    }

    public static void main(String[] args) {
        StackWithTwoQuenes<Integer> stack = new StackWithTwoQuenes<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
    }
}
