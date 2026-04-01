public class profitLoss {
    public static void main(String[] args) {
        //Given variables
        double costPrice = 129;
        double sellingPrice = 191;

        //Calculating profit or loss
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;

        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice+
                     "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage + "%");
    }
    
}
