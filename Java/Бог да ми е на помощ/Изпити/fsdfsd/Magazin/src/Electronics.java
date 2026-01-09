public class Electronics extends Product {
    private String manufacturer;
    private String model;

    public Electronics() {

    }

    public Electronics(int inventoryNumber, double price, int quantity, Provider provider, String manufacturer,
            String model) {
        super(inventoryNumber, price, quantity, provider);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public double getPromotionalPrice() {
        double price = getPrice() - getPrice() * 0.1;
        return price;
    }

    @Override
    public boolean sellProduct(int piece) throws NoMoreProductException {
        return false;
    }
}
