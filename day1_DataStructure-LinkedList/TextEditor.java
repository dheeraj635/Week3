public class TextEditor {
    private static class Node {
        String text;
        Node prev, next;

        Node(String text) {
            this.text = text;
        }
    }

    private Node current;
    private int size = 0;
    private final int maxSize = 10;

    public TextEditor() {
        current = new Node("");
    }

    public void addState(String text) {
        Node newNode = new Node(text);
        newNode.prev = current;
        current.next = newNode;
        current = newNode;

        size++;
        if (size > maxSize) {
            Node temp = current;
            while (temp.prev != null && size > maxSize) {
                temp = temp.prev;
                size--;
            }
            temp.prev = null;
        }
    }

    public void undo() {
        if (current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    public void displayCurrentState() {
        System.out.println("Current State: " + current.text);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");

        editor.displayCurrentState(); 

        editor.undo();
        editor.displayCurrentState(); 

        editor.undo();
        editor.displayCurrentState(); 

        editor.redo();
        editor.displayCurrentState(); 
    }
}
