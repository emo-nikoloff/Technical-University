import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private final int id;
    private final String clientName;
    private final Equipment equipment;
    private final LocalDate fromDate;
    private final LocalDate toDate;
    private final double totalPrice;

    public Reservation(int id, String clientName,
            Equipment equipment,
            LocalDate fromDate,
            LocalDate toDate,
            double totalPrice) {
        this.id = id;
        this.clientName = clientName;
        this.equipment = equipment;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public long getDays() {
        return ChronoUnit.DAYS.between(fromDate, toDate) + 1;
    }

    @Override
    public String toString() {
        return "Res#" + id + ": " + clientName + " -> " +
                equipment.getType() + "(" + equipment.getId() + ") " +
                fromDate + ".." + toDate +
                " days=" + getDays() +
                " total=" + totalPrice;
    }
}
