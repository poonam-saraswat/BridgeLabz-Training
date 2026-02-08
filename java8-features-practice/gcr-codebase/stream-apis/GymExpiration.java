import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

class Member{
    private String name; 
    private LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate){
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getName(){ return name; }
    public LocalDate getExpiryDate(){return expiryDate; }

    @Override
    public String toString(){
        return name + " - gym membership expires on: " + expiryDate;
    }
}

public class GymExpiration {
    public static void main(String[] args){
        List<Member> members = List.of(
            new Member("Amit", LocalDate.now().plusDays(10)),
            new Member("Neha", LocalDate.now().plusDays(40)),
            new Member("Rahul", LocalDate.now().plusDays(25)),
            new Member("Priya", LocalDate.now().minusDays(5)), 
            new Member("Karan", LocalDate.now().plusDays(30))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<Member> expire = members.stream()
            .filter(member -> !member.getExpiryDate().isBefore(today) && member.getExpiryDate().isBefore(next30Days.plusDays(1)))
            .collect(Collectors.toList());

        expire.forEach(System.out::println);
    }
}
