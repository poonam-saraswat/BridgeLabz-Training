// Node class representing each Item in Inventory
class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Singly Linked List Inventory Management System
class Inventory {
    private ItemNode head = null;

    // Add item at the beginning
    public void addItemAtBeginning(String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Add item at the end
    public void addItemAtEnd(String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add item at a specific position (1-based index)
    public void addItemAtPosition(String name, int id, int qty, double price, int position) {
        if (position == 1) {
            addItemAtBeginning(name, id, qty, price);
            return;
        }
        ItemNode newNode = new ItemNode(name, id, qty, price);
        ItemNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove item by Item ID
    public void removeItemById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item with ID " + id + " removed.");
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with ID " + id + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + id + " removed.");
        }
    }

    // Update quantity by Item ID
    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated for Item ID " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    // Search by Item ID
    public void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                System.out.println("Found Item: [ID=" + temp.itemId + ", Name=" + temp.itemName +
                        ", Qty=" + temp.quantity + ", Price=" + temp.price + "]");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    // Search by Item Name
    public void searchByName(String name) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                System.out.println("Found Item: [ID=" + temp.itemId + ", Name=" + temp.itemName +
                        ", Qty=" + temp.quantity + ", Price=" + temp.price + "]");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with Name '" + name + "' not found.");
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    // Display all items
    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        ItemNode temp = head;
        while (temp != null) {
            System.out.println("[ID=" + temp.itemId + ", Name=" + temp.itemName +
                    ", Qty=" + temp.quantity + ", Price=" + temp.price + "]");
            temp = temp.next;
        }
    }

    // Merge Sort for sorting by Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
    }

    private ItemNode mergeSort(ItemNode h, String criteria, boolean ascending) {
        if (h == null || h.next == null) return h;

        ItemNode middle = getMiddle(h);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(h, criteria, ascending);
        ItemNode right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    private ItemNode sortedMerge(ItemNode a, ItemNode b, String criteria, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        ItemNode result;
        boolean condition;

        if (criteria.equalsIgnoreCase("name")) {
            condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                                  : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else { // sort by price
            condition = ascending ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, criteria, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, criteria, ascending);
        }
        return result;
    }

    private ItemNode getMiddle(ItemNode h) {
        if (h == null) return h;
        ItemNode slow = h, fast = h.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
}

// Driver class
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addItemAtEnd("Laptop", 101, 5, 55000);
        inventory.addItemAtEnd("Mouse", 102, 20, 500);
        inventory.addItemAtBeginning("Keyboard", 103, 15, 1500);
        inventory.addItemAtPosition("Monitor", 104, 10, 12000, 2);

        System.out.println("\nAll Items:");
        inventory.displayAllItems();

        System.out.println("\nSearch by ID (102):");
        inventory.searchById(102);

        System.out.println("\nSearch by Name (Laptop):");
        inventory.searchByName("Laptop");

        System.out.println("\nUpdate Quantity of Item ID 101:");
        inventory.updateQuantity(101, 8);

        System.out.println("\nAll Items After Update:");
        inventory.displayAllItems();

        System.out.println("\nTotal Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nSorting by Name Ascending:");
        inventory.sortInventory("name", true);
        inventory.displayAllItems();

        System.out.println("\nSorting by Price Descending:");
        inventory.sortInventory("price", false);
        inventory.displayAllItems();

        System.out.println("\nRemoving Item with ID 102:");
        inventory.removeItemById(102);
        inventory.displayAllItems();
    }
}
