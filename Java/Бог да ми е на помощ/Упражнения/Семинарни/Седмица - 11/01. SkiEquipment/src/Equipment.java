public class Equipment {

    private final int id;
    private final EquipmentType type;
    private final String size;
    private final double pricePerDay;

    public Equipment(int id, EquipmentType type, String size, double pricePerDay) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.pricePerDay = pricePerDay;
    }

    public int getId() {
        return id;
    }

    public EquipmentType getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return "ID=" + id +
                " " + type +
                " size=" + size +
                " pricePerDay=" + pricePerDay;
    }
}
