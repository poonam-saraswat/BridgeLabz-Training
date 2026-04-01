import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Goods Transport details: ");
        String details = sc.nextLine();

        Utility util = new Utility();

        GoodsTransport transport = util.parseDetails(details);
        if(!util.validateTransportId(transport.getTransportId())){
            System.out.println("Transport id " + transport.getTransportId() + " is invalid,");
            System.out.println("Please provide a valid record");
            return;
        }

        String objectType = util.findObjectType(transport);

        double totalCharge = 0.0;

        if(objectType.equalsIgnoreCase("BrickTransport")){
            BrickTransport bt = (BrickTransport) transport;
            if(!util.validateTransportId(bt.getTransportId())){
                return;
            }
            totalCharge = bt.calculateTotalCharge();

            System.out.println("Transport id : " + bt.getTransportId());
            System.out.println("Date of transport : " + bt.getTransportDate());
            System.out.println("Rating of the transport : " + bt.getTransportRating());
            System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
            System.out.println("Brick price : " + bt.getBrickPrice());
            System.out.println("Vehicle for tranport : " + bt.VehicleSelection());
            System.out.println("Total charge : " + totalCharge);
        }
        else if(objectType.equalsIgnoreCase("TimberTransport")){
            TimberTransport tt = (TimberTransport) transport;
            if(!util.validateTransportId(tt.getTransportId())){
                return;
            }
            totalCharge = tt.calculateTotalCharge();

            System.out.println("Transport id : " + tt.getTransportId());
            System.out.println("Date of transport : " + tt.getTransportDate());
            System.out.println("Rating of the transport : " + tt.getTransportRating());
            System.out.println("Type of timber : " + tt.getTimberType());
            System.out.println("Timber price per kilo : " + tt.getTimberPrice());
            System.out.println("Vehicle for tranport : " + tt.VehicleSelection());
            System.out.println("Total charge : " + totalCharge);
        }
    }
}