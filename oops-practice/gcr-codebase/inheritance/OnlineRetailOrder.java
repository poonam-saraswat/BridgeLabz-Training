import java.time.LocalDate;
class Order {
    private String orderId;
    private LocalDate orderDate;

    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }
}
class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }
}
class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }
}
public class OnlineRetailOrder {
    public static void main(String[] args) {
        Order order = new Order("ORD123", LocalDate.of(2024, 6, 1));
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Order Status: " + order.getOrderStatus());

        ShippedOrder shippedOrder = new ShippedOrder("ORD124", LocalDate.of(2024, 6, 2), "TRK456");
        System.out.println("\nOrder ID: " + shippedOrder.getOrderId());
        System.out.println("Order Date: " + shippedOrder.getOrderDate());
        System.out.println("Tracking Number: " + shippedOrder.getTrackingNumber());
        System.out.println("Order Status: " + shippedOrder.getOrderStatus());

        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD125", LocalDate.of(2024, 6, 3), "TRK789", LocalDate.of(2024, 6, 10));
        System.out.println("\nOrder ID: " + deliveredOrder.getOrderId());
        System.out.println("Order Date: " + deliveredOrder.getOrderDate());
        System.out.println("Tracking Number: " + deliveredOrder.getTrackingNumber());
        System.out.println("Delivery Date: " + deliveredOrder.getDeliveryDate());
        System.out.println("Order Status: " + deliveredOrder.getOrderStatus());
    }
}