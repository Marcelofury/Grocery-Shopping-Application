import java.util.Scanner;

public class GroceryApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Product catalog data stored in parallel arrays
        String[] productNames = {"Apple", "Milk", "Bread", "Eggs", "Rice"};
        double[] productPrices ={1.20, 2.50, 2.00, 3.50, 5.00};
        int[] productStock = {50, 20, 30, 40, 15};

        // Cart quantities corresponding to each product index

        int[] cartQuantities = new int[productNames.length];

        boolean running = true;

        while (running){
            System.out.println("\n=== GROCERY STORE MENU");
            System.out.println("1. View Products and Add to Cart");
            System.out.println("2. View Shopping Cart and Total");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
        }
    }
}
