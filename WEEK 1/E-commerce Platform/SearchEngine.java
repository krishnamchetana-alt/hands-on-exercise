import java.util.List;

public class SearchEngine {

    // 1. Linear Search Implementation
    public static Product linearSearch(List<Product> products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // 2. Binary Search Implementation (Assumes the list is sorted)
    public static Product binarySearch(List<Product> sortedProducts, String targetName) {
        int low = 0;
        int high = sortedProducts.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Product midProduct = sortedProducts.get(mid);
            int comparison = midProduct.getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return midProduct;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}