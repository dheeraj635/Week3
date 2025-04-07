
import java.util.Scanner;

class Stack {
    int[] arr;
    int[] index;
    int top;
    int size;

    Stack(int size) {
        this.size = size;
        arr = new int[size];
        index = new int[size];
        top = -1;
    }

    void push(int val, int i) {
        if (top < size - 1) {
            arr[++top] = val;
            index[top] = i;
        }
    }

    void pop() {
        if (top >= 0) {
            top--;
        }
    }

    int peek() {
        if (top >= 0) {
            return arr[top];
        }
        return -1;
    }

    int peekIndex() {
        if (top >= 0) {
            return index[top];
        }
        return -1;
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class Span_problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        int[] span = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        Stack stack = new Stack(n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= price[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peekIndex();
            }
            stack.push(price[i], i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
        sc.close();
    }
}



