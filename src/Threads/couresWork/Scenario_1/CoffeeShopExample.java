package Threads.couresWork.Scenario_1;

// Main class to test the CoffeeShop system with multiple customers and baristas
public class CoffeeShopExample {
    public final static int CAPACITY = 5; // Fixed capacity for the coffee shop

    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop(CAPACITY);

        Thread[] customersBaristars = new Thread[CAPACITY * 2];

        // Creating alternating Customer and Barista threads
        for (int i = 0; i < CAPACITY; i++) {
            customersBaristars[i * 2] = new Thread(new Customer(coffeeShop, "order " + (i + 1)), "Customer " + (i + 1));
            customersBaristars[i * 2 + 1] = new Thread(new Barista(coffeeShop), "Barista " + (i + 1));
        }

        // Starting all threads
        for (Thread customerOrBarista : customersBaristars) {
            customerOrBarista.start();
        }
    }
}
