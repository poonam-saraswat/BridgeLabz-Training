import java.util.*;

// Doubly Linked List Node for history
class HistoryNode {
    String url;
    HistoryNode prev, next;

    HistoryNode(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

// Tab class maintains its own history
class Tab {
    private HistoryNode current;

    public Tab(String url) {
        current = new HistoryNode(url);
    }

    // Visit a new page
    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
        System.out.println("Visited: " + url);
    }

    // Go back
    public void back() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page!");
        }
    }

    // Go forward
    public void forward() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No forward page!");
        }
    }

    // Show current page
    public void showCurrent() {
        System.out.println("Current Page: " + current.url);
    }
}

// BrowserBuddy manages multiple tabs
class BrowserBuddy {
    private List<Tab> openTabs;
    private Stack<Tab> closedTabs;

    public BrowserBuddy() {
        openTabs = new ArrayList<>();
        closedTabs = new Stack<>();
    }

    // Open new tab
    public void openTab(String url) {
        Tab tab = new Tab(url);
        openTabs.add(tab);
        System.out.println("Opened new tab with: " + url);
    }

    // Close tab
    public void closeTab(int index) {
        if (index >= 0 && index < openTabs.size()) {
            Tab tab = openTabs.remove(index);
            closedTabs.push(tab);
            System.out.println("Closed tab at index " + index);
        } else {
            System.out.println("Invalid tab index!");
        }
    }

    // Restore recently closed tab
    public void restoreTab() {
        if (!closedTabs.isEmpty()) {
            Tab tab = closedTabs.pop();
            openTabs.add(tab);
            System.out.println("Restored a recently closed tab.");
        } else {
            System.out.println("No closed tabs to restore!");
        }
    }

    // Get tab by index
    public Tab getTab(int index) {
        if (index >= 0 && index < openTabs.size()) {
            return openTabs.get(index);
        }
        System.out.println("Invalid tab index!");
        return null;
    }

    // Show all open tabs
    public void showTabs() {
        System.out.println("Open Tabs:");
        for (int i = 0; i < openTabs.size(); i++) {
            System.out.println(i + ": Tab");
        }
    }
}

// Demo class with user input
public class BrowserBuddyDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BrowserBuddy browser = new BrowserBuddy();

        int choice;
        do {
            System.out.println("\n--- BrowserBuddy Menu ---");
            System.out.println("1. Open New Tab");
            System.out.println("2. Close Tab");
            System.out.println("3. Restore Recently Closed Tab");
            System.out.println("4. Visit Page in Tab");
            System.out.println("5. Back in Tab");
            System.out.println("6. Forward in Tab");
            System.out.println("7. Show Current Page in Tab");
            System.out.println("8. Show All Tabs");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to open: ");
                    String url = sc.nextLine();
                    browser.openTab(url);
                    break;
                case 2:
                    browser.showTabs();
                    System.out.print("Enter tab index to close: ");
                    int closeIndex = sc.nextInt();
                    browser.closeTab(closeIndex);
                    break;
                case 3:
                    browser.restoreTab();
                    break;
                case 4:
                    browser.showTabs();
                    System.out.print("Enter tab index: ");
                    int tabIndex = sc.nextInt();
                    sc.nextLine();
                    Tab tab = browser.getTab(tabIndex);
                    if (tab != null) {
                        System.out.print("Enter URL to visit: ");
                        String newUrl = sc.nextLine();
                        tab.visit(newUrl);
                    }
                    break;
                case 5:
                    browser.showTabs();
                    System.out.print("Enter tab index: ");
                    int backIndex = sc.nextInt();
                    Tab backTab = browser.getTab(backIndex);
                    if (backTab != null) backTab.back();
                    break;
                case 6:
                    browser.showTabs();
                    System.out.print("Enter tab index: ");
                    int forwardIndex = sc.nextInt();
                    Tab forwardTab = browser.getTab(forwardIndex);
                    if (forwardTab != null) forwardTab.forward();
                    break;
                case 7:
                    browser.showTabs();
                    System.out.print("Enter tab index: ");
                    int showIndex = sc.nextInt();
                    Tab showTab = browser.getTab(showIndex);
                    if (showTab != null) showTab.showCurrent();
                    break;
                case 8:
                    browser.showTabs();
                    break;
                case 9:
                    System.out.println("Exiting BrowserBuddy...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 9);

        sc.close();
    }
}