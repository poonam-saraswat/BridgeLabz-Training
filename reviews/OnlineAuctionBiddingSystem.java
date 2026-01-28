
import java.util.*;
//custom exception to show invalid bids
class InvalidBidException extends Exception{
	public InvalidBidException(String message) {
		super(message);
	}
}

//User class to store bidder details
class User{
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	 
	//Overriding toString
	@Override
	public String toString() {
		return name;
	}
}
//Main class to manage the auction item
class AuctionItem{
	private String itemName;
	private double currentHighestBid = 0.0;
	
	//TreeMap to store user as key and bid amount as value
	private TreeMap<User, Double>bids = new TreeMap<>((u1,u2)->{
		return 1;
	});
	public AuctionItem(String itemName) {
		this.itemName = itemName;
	}
	
	//method to place a bid
	public void placeBid(User user, double amount)throws InvalidBidException{
		if(amount <= currentHighestBid) {
			throw new InvalidBidException("Bid of $ " + amount + "is too low !");
		}
		bids.put(user,  amount);
		currentHighestBid = amount;
		System.out.println("Bid accepted:" + user.getName()+ "bid amount" + amount);
	}
	public void displayHighestBid(){
		if(currentHighestBid ==0) {
			System.out.println("No bids placed yet !");
		}else {
			System.out.println("Current highest bid for " + itemName +" :$" + currentHighestBid);
		}
	
	}
}
//Main class to run the auction system
public class OnlineAuctionBiddingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuctionItem vintageWatch = new AuctionItem("Vintage Watch");

        System.out.println("--- Welcome to the Online Auction for: Vintage Watch ---");
        System.out.println("Type 'exit' as the name to close the auction.");

        while (true) {
            try {
                System.out.print("\nEnter bidder name: ");
                String name = scanner.nextLine();

                if (name.equalsIgnoreCase("exit")) break;

                System.out.print("Enter bid amount: ");
                // Read input as string and parse to avoid scanner skip issues
                double amount = Double.parseDouble(scanner.nextLine());

                User bidder = new User(name);
                vintageWatch.placeBid(bidder, amount);
                vintageWatch.displayHighestBid();

            } catch (InvalidBidException e) {
                System.out.println("Auction Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numeric value for the bid.");
            }
        }

        System.out.println("\nAuction closed. Thank you!");
        scanner.close();
    }
}