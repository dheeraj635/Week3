
import java.util.Scanner;

class Stack {
    int[] arr;
    int top;
    int size;

    Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int x) {
        if (top < size - 1) {
            arr[++top] = x;
        }
    }

    int pop() {
        if (top >= 0) {
            return arr[top--];
        }
        return -1;
    }

    int peek() {
        if (top >= 0) {
            return arr[top];
        }
        return -1;
    }

    boolean isEmpty() {
        return top == -1;
    }
}

class QueueUsingStacks {
    Stack stack1;
    Stack stack2;

    QueueUsingStacks(int size) {
        stack1 = new Stack(size);
        stack2 = new Stack(size);
    }

    void enqueue(int x) {
        stack1.push(x);
    }

    int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

public class Queue_using_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks queue = new QueueUsingStacks(100);
        while (true) {
            int choice = sc.nextInt();
            if (choice == 1) {
                int val = sc.nextInt();
                queue.enqueue(val);
            } else if (choice == 2) {
                int removed = queue.dequeue();
                if (removed == -1) {
                    System.out.println("Queue is empty");
                } else {
                    System.out.println("Dequeued: " + removed);
                }
            } else {
                break;
            }
        }
        sc.close();
    }
}



