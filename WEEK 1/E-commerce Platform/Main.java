import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize data
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product(101, "Wireless Mouse", "Electronics"));
        catalog.add(new Product(104, "Mechanical Keyboard", "Electronics"));
        catalog.add(new Product(102, "Running Shoes", "Apparel"));
        catalog.add(new Product(105, "Coffee Mug", "Kitchen"));
        catalog.add(new Product(103, "Gaming Headset", "Electronics"));

        String target = "Gaming Headset";

        System.out.println("=== E-Commerce Search Execution (Week 1 DSA) ===\n");

        // 2. Run Linear Search
        System.out.println("[Executing Linear Search...]");
        long startTime = System.nanoTime();
        Product result1 = SearchEngine.linearSearch(catalog, target);
        long endTime = System.nanoTime();
        
        System.out.println("Result: " + (result1 != null ? result1 : "Product Not Found"));
        System.out.println("Execution Time: " + (endTime - startTime) + " ns\n");

        // 3. Sort for Binary Search
        System.out.println("[Sorting catalog alphabetically for Binary Search...]");
        SortUtils.sortProductsByName(catalog);
        
        // 4. Run Binary Search
        System.out.println("[Executing Binary Search...]");
        startTime = System.nanoTime();
        Product result2 = SearchEngine.binarySearch(catalog, target);
        endTime = System.nanoTime();

        System.out.println("Result: " + (result2 != null ? result2 : "Product Not Found"));
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}