import java.util.ArrayList;

// Node class representing each User
class UserNode {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

// Singly Linked List Social Media Friend Connections
class SocialMedia {
    private UserNode head = null;

    // Add a new user
    public void addUser(int id, String name, int age) {
        UserNode newNode = new UserNode(id, name, age);
        if (head == null) {
            head = newNode;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Search user by ID
    public UserNode searchById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name
    public UserNode searchByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection between two users
    public void addFriendConnection(int id1, int id2) {
        UserNode user1 = searchById(id1);
        UserNode user2 = searchById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(id2)) user1.friendIds.add(id2);
        if (!user2.friendIds.contains(id1)) user2.friendIds.add(id1);

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove friend connection
    public void removeFriendConnection(int id1, int id2) {
        UserNode user1 = searchById(id1);
        UserNode user2 = searchById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(id2));
        user2.friendIds.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Display all friends of a specific user
    public void displayFriends(int id) {
        UserNode user = searchById(id);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ": " + user.friendIds);
    }

    // Find mutual friends between two users
    public void findMutualFriends(int id1, int id2) {
        UserNode user1 = searchById(id1);
        UserNode user2 = searchById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        ArrayList<Integer> mutual = new ArrayList<>();
        for (int f : user1.friendIds) {
            if (user2.friendIds.contains(f)) {
                mutual.add(f);
            }
        }

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutual);
    }

    // Count number of friends for each user
    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println("[ID=" + temp.userId + ", Name=" + temp.name +
                    ", Age=" + temp.age + ", Friends=" + temp.friendIds + "]");
            temp = temp.next;
        }
    }
}

// Driver class
public class SocialMediaFriends {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "David", 28);

        System.out.println("\nAll Users:");
        sm.displayAllUsers();

        System.out.println("\nAdding Friend Connections:");
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 4);

        System.out.println("\nDisplaying Friends:");
        sm.displayFriends(1);
        sm.displayFriends(2);

        System.out.println("\nFinding Mutual Friends between Alice and Bob:");
        sm.findMutualFriends(1, 2);

        System.out.println("\nCounting Friends:");
        sm.countFriends();

        System.out.println("\nRemoving Friend Connection between Alice and Bob:");
        sm.removeFriendConnection(1, 2);

        System.out.println("\nDisplaying Friends After Removal:");
        sm.displayFriends(1);
        sm.displayFriends(2);
    }
}
