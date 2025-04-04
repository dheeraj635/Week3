package day13;

import java.util.Scanner;

class item {
    int itemId;
    String itemName;
    int quantity;
    double price;
    item next;

    item(int itemId, String itemName, int quantity, double price){
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}

class InventoryLinkedList {
    item head;

    public void addFirst(int itemId, String itemName, int quantity, double price){
        item newitem = new item(itemId, itemName, quantity, price);
        newitem.next = head;
        head = newitem;
    }

    public void addLast(int itemId, String itemName, int quantity, double price){
        item newitem = new item(itemId, itemName, quantity, price);
        if(head == null){
            head = newitem;
            return;
        }
        item current = head;
        while (current.next != null){
            current= current.next;
        }

        current.next = newitem;        
    }

    public void addAtPosition(int index, int itemId, String itemName, int quantity, double price){
        if (index ==0){
            addFirst(itemId, itemName, quantity, price);
            return;
        }
        item newitem = new item(itemId, itemName, quantity, price);
        item current = head;
        for(int i=0;i<index-1 && current!=null;i++){
            current = current.next;
        }
        if (current == null){
            System.out.println("Position out of bounds");
            return;
        }

        newitem.next = current.next;
        current.next = newitem;
    }
    public void removeId(int itemId){
        if (head == null) return;
    
        if (head.itemId == itemId){
            head = head.next;
            System.out.println("Removed Successfully");
            return;
        }
    
        item current = head;
        while(current.next != null && current.next.itemId != itemId){
            current = current.next;
        }
    
        if(current.next == null){
            System.out.println("Item not found");
        } else {
            current.next = current.next.next;
            System.out.println("Removed Successfully");
        }
    }
    

    public void updatequantity(int itemId, int newquantity){
        item current = head;
        while (current != null){
            if(current.itemId == itemId){
                current.quantity = newquantity;
                System.out.println("Updated successfully");
                return;
            }
            current = current.next;
        }
        System.out.println("Item is not found");
    }

    public void searchItem(int itemId){
        //item newitem = new item(int itemId, String itemName, int quantity, double price);

        item current = head;
        while(current !=null){
            if(current.itemId == itemId){
                displayItem(current);
                return;
            }
            current = current.next;
        }
        System.out.println("Item is not found");
    }

    public void displayItem(item newitem) {
        System.out.println("ID: " + newitem.itemId + ", Name: " + newitem.itemName + ", Quantity: " + newitem.quantity + ", Price: " + newitem.price);
    }

    public void display(){
        if (head == null){
            System.out.println("Inventory is empty");
            return;
        }

        item current = head;
        System.out.println("Inventory List : ");
        while (current != null){
            displayItem(current);
            current = current.next;
        }
    }

    public void calculateTotalValue() {
        double total = 0;
        item current = head;
        while (current != null) {
            total += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total Inventory Value: $" + total);
    }

    public void sortInventory(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
    }

    private item mergeSort(item head, String criteria, boolean ascending) {
        if (head == null || head.next == null)
            return head;

        item middle = getMiddle(head);
        item nextOfMiddle = middle.next;
        middle.next = null;

        item left = mergeSort(head, criteria, ascending);
        item right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    private item sortedMerge(item a, item b, String criteria, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        int compare;
        if (criteria.equalsIgnoreCase("name")) {
            compare = a.itemName.compareToIgnoreCase(b.itemName);
        } else {
            compare = Double.compare(a.price, b.price);
        }

        if (!ascending) compare *= -1;

        item result;
        if (compare <= 0) {
            result = a;
            result.next = sortedMerge(a.next, b, criteria, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, criteria, ascending);
        }

        return result;
    }

    private item getMiddle(item head) {
        if (head == null) return head;

        item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
public class InventoryApp {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search by ID");
            System.out.println("7. Display All Items");
            System.out.println("8. Calculate Total Value");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Price");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int id, qty, pos;
            String name;
            double price;

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Quantity, Price: ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    inventory.addFirst(id, name, qty, price);
                    break;
                case 2:
                    System.out.print("Enter ID, Name, Quantity, Price: ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    inventory.addLast(id, name, qty, price);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter ID, Name, Quantity, Price: ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    inventory.addAtPosition(pos, id, name, qty, price);
                    break;
                case 4:
                    System.out.print("Enter ID to remove: ");
                    id = sc.nextInt();
                    inventory.removeId(id);
                    break;
                case 5:
                    System.out.print("Enter ID and New Quantity: ");
                    id = sc.nextInt();
                    qty = sc.nextInt();
                    inventory.updatequantity(id, qty);
                    break;
                case 6:
                    System.out.print("Enter ID to search: ");
                    id = sc.nextInt();
                    inventory.searchItem(id);
                    break;
                case 7:
                    inventory.display();
                    break;
                case 8:
                    inventory.calculateTotalValue();
                    break;
                case 9:
                    inventory.sortInventory("name", true);
                    System.out.println("Sorted by Name (Ascending)");
                    break;
                case 10:
                    inventory.sortInventory("price", true);
                    System.out.println("Sorted by Price (Ascending)");
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 11);

        sc.close();
    
    }
}
