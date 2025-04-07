
import java.util.Scanner;

class Deque {
    int[] arr;
    int front;
    int rear;
    int size;

    Deque(int size) {
        arr = new int[size];
        front = 0;
        rear = -1;
        this.size = 0;
    }

    void pushBack(int val) {
        arr[++rear] = val;
        size++;
    }

    void popBack() {
        if (size > 0) {
            rear--;
            size--;
        }
    }

    void popFront() {
        if (size > 0) {
            front++;
            size--;
        }
    }

    int front() {
        return arr[front];
    }

    int back() {
        return arr[rear];
    }

    boolean isEmpty() {
        return size == 0;
    }
}

public class window_maximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Deque deque = new Deque(n);
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.back()] <= nums[i]) {
                deque.popBack();
            }
            deque.pushBack(i);
            if (deque.front() <= i - k) {
                deque.popFront();
            }
            if (i >= k - 1) {
                System.out.print(nums[deque.front()] + " ");
            }
        }
        sc.close();
    }
}



