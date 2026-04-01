import java.util.List;

public class EmailNotifications {
    public static void main(String[] args){
        List<String> emails = List.of(
            "alankrati@gmail.com", "shivang@gmail.com", "ayushi@gmail.com", "shruti@gmail.com", "sankalp@gmail.com"
        );

        emails.forEach(email -> sendEmailNotification(email));
    }

    public static void sendEmailNotification(String email){
        System.out.println("You have a notification at: " + email);
    }
}
