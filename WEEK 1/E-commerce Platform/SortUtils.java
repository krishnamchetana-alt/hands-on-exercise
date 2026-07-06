import java.util.List;

public class SortUtils {
    // Sorts products alphabetically by name using Bubble Sort
    public static void sortProductsByName(List<Product> products) {
        int n = products.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (products.get(j).getProductName().compareToIgnoreCase(products.get(j + 1).getProductName()) > 0) {
                    // Swap
                    Product temp = products.get(j);
                    products.set(j, products.get(j + 1));
                    products.set(j + 1, temp);
                }
            }
        }
    }
}