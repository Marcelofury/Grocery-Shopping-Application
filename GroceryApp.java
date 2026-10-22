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

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("\n--- AVAILABLE PRODUCTS ---");
                    for(int i = 0; i < productNames.length; i++){
                        System.out.println((i + 1) + ". " + productNames[i] + " -$" + productPrices[i] + "Stock: " + productStock[i] +")");

                    }
                    System.out.print("Enter product number to buy (or 0 to go back): ")
                    int prodIndex = scanner.nextInt() -1;

                    if (prodIndex >= 0 && prodIndex < productNames.length){
                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();

                        if (qty > 0 && qty <= productStock[prodIndex]){
                            cartQuantities[prodIndex] += qty;
                            productStock[prodIndex] -= qty;
                            System.out.println("Added " + qty + " " + productNames[prodIndex] + "(s) to your cart".);
                        } else {
                            System.out.println("Invalid quantity or insufficient stock.");
                        }

                    
                    }
                    break;

                    case 2:
                        System.out.println("\n--- YOUR SHOPPING CART");
                        double total = 0;
                        boolean isEmpty = true;
                        for(int i =0; i < cartQuantities.length; i++){
                            if (cartQuantities[i] > 0){
                                double cost = cartQuantities[i] * productPrices[i];
                                total += cost;
                                System.out.println(productNames[i] + " x " + cartQuantities[i] + " = $" + String.format("%..2f", cost));
                                isEmpty = false; 
                            }

                        }
                        if(isEmpty){
                            System.out.println("Your cart is Empty");
                            
                        } else {
                            System.out.println("Total Amount: $" + String.format("%.2f",total));

                        }
                        break;

                        case 3:
                            double finalTotal = 0;
                            System.out.println("\n---CHECKOUT RECEIPT ---");
                            for (int i = 0; i < cartQuantities.length; i++){
                                if(cartQuantities[i] > 0){
                                    double cost = cartQuantities[i] * productPrices[i];
                                    finalTotal += cost;
                                    System.out.println(productNames[i] + " x " + cartQuantities[i] + " $" + String.format("%.2f", cost));

                                }
                            }
                            System.out.println("Grand Total: $" + String.format("%.2f", finalTotal));
                            System.out.println("Thank you for shopping with us!");
                            running = false;
                            break;

                        case 4:
                            System.out.println("Exiting Application.Goodbye!");
                            running = false;
                            break;

                        default:
                            System.out.println("Invalid option. Please try again.");


                    
            }
        }

        scanner.close();
    }
}
