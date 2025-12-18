import java.util.Comparator;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public static List<Product> getProductsByCategory(List<Product> products, String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toList();
    }

    public static List<Product> getExpensiveProducts(List<Product> products, double minPrice) {
        return products.stream()
                .filter(p -> p.getPrice() > minPrice)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .toList();
    }

    @Override
    public String toString() {
        return name + " - " + price + " (" + category + ")";
    }
}
