import java.util.List;

public class Shop {
    public static void main(String[] args) throws Exception {
        List<Product> products = List.of(
                new Product("Phone", 1200, "tech"),
                new Product("Laptop", 2400, "tech"),
                new Product("Sofa", 900, "furniture"),
                new Product("Tablet", 800, "tech"));

        List<Product> productsCategory = Product.getProductsByCategory(products, "tech");
        System.out.println(productsCategory);

        List<Product> expensiveProducts = Product.getExpensiveProducts(products, 900);
        System.out.println(expensiveProducts);

    }
}
