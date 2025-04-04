
import java.util.ArrayList;
import java.util.List;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    public void addFriend(int friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    public void removeFriend(int friendId) {
        friendIds.remove(Integer.valueOf(friendId));
    }
}

class SocialMedia {
    private User head;

    public SocialMedia() {
        head = null;
    }

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
        }
    }

    public List<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friendId : user1.friendIds) {
                if (user2.friendIds.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + " (User ID: " + user.userId + "): " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    public User findUser(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public User findUserByName(String name) {
        User current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void countFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println(user.name + " (User ID: " + user.userId + ") has " + user.friendIds.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayAllUsers() {
        User current = head;
        while (current != null) {
            System.out.println("User ID: " + current.userId + ", Name: " + current.name + ", Age: " + current.age);
            current = current.next;
        }
    }
}

public class SocialMediaDemo {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();

        socialMedia.addUser(1, "Alice", 25);
        socialMedia.addUser(2, "Bob", 30);
        socialMedia.addUser(3, "Charlie", 28);

        socialMedia.addFriendConnection(1, 2);
        socialMedia.addFriendConnection(2, 3);
        socialMedia.addFriendConnection(1, 3);

        socialMedia.displayFriends(1);

        List<Integer> mutualFriends = socialMedia.findMutualFriends(1, 2);
        System.out.println("Mutual friends between Alice and Bob: " + mutualFriends);

        User user = socialMedia.findUserByName("Charlie");
        if (user != null) {
            System.out.println("Found user: " + user.name + " (User ID: " + user.userId + ")");
        } else {
            System.out.println("User not found.");
        }

        socialMedia.countFriends(2);

        socialMedia.removeFriendConnection(1, 2);
        socialMedia.displayFriends(1);

        socialMedia.displayAllUsers();
    }
}



