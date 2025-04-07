
import java.util.Scanner;

class Node {
    int key, value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class CustomHashMap {
    private Node[] table;
    private int size;

    CustomHashMap(int capacity) {
        table = new Node[capacity];
        size = capacity;
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            newNode.next = table[index];
            table[index] = newNode;
        }
    }

    public Integer get(int key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

public class custom_hashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomHashMap map = new CustomHashMap(10);

        while (true) {
            System.out.println("1. Insert key-value pair");
            System.out.println("2. Get value by key");
            System.out.println("3. Remove key-value pair");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                map.put(key, value);
            } else if (choice == 2) {
                int key = sc.nextInt();
                Integer value = map.get(key);
                if (value != null) {
                    System.out.println("Value: " + value);
                } else {
                    System.out.println("Key not found");
                }
            } else if (choice == 3) {
                int key = sc.nextInt();
                map.remove(key);
            } else {
                break;
            }
        }
        sc.close();
    }
}



