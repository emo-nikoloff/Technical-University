import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SkiCenter {

    private final Map<Integer, Equipment> equipmentMap = new LinkedHashMap<>();
    private final Map<Integer, Reservation> reservations = new LinkedHashMap<>();
    private final AtomicInteger nextReservationId = new AtomicInteger(1);

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;

    public SkiCenter() {
        addEquipment(new Equipment(1, EquipmentType.SKI, "150", 25.0));
        addEquipment(new Equipment(2, EquipmentType.SKI, "160", 27.0));
        addEquipment(new Equipment(3, EquipmentType.SKI, "170", 30.0));

        addEquipment(new Equipment(4, EquipmentType.SNOWBOARD, "145", 28.0));
        addEquipment(new Equipment(5, EquipmentType.SNOWBOARD, "155", 30.0));

        addEquipment(new Equipment(6, EquipmentType.BOOTS, "40", 15.0));
        addEquipment(new Equipment(7, EquipmentType.BOOTS, "42", 15.0));
        addEquipment(new Equipment(8, EquipmentType.BOOTS, "44", 15.0));

        addEquipment(new Equipment(9, EquipmentType.POLES, "110", 8.0));
        addEquipment(new Equipment(10, EquipmentType.POLES, "120", 8.0));

        addEquipment(new Equipment(11, EquipmentType.HELMET, "S", 10.0));
        addEquipment(new Equipment(12, EquipmentType.HELMET, "M", 10.0));
        addEquipment(new Equipment(13, EquipmentType.HELMET, "L", 10.0));
    }

    private void addEquipment(Equipment equipment) {
        equipmentMap.put(equipment.getId(), equipment);
    }

    public synchronized List<Equipment> listAvailableForDate(LocalDate date) {
        Set<Integer> reservedIds = new HashSet<>();

        for (Reservation res : reservations.values()) {
            if (!date.isBefore(res.getFromDate()) && !date.isAfter(res.getToDate())) {
                reservedIds.add(res.getEquipment().getId());
            }
        }

        return equipmentMap.values()
                .stream()
                .filter(eq -> !reservedIds.contains(eq.getId()))
                .collect(Collectors.toList());
    }

    public synchronized List<Equipment> filter(EquipmentType type, String sizeFrom, String sizeTo) {
        String from = (sizeFrom == null) ? "" : sizeFrom.trim();
        String to = (sizeTo == null) ? "" : sizeTo.trim();

        return equipmentMap.values()
                .stream()
                .filter(eq -> eq.getType() == type)
                .filter(eq -> matchSize(eq.getSize(), from, to))
                .collect(Collectors.toList());
    }

    private boolean matchSize(String eqSize, String from, String to) {
        if (from.isEmpty() && to.isEmpty()) {
            return true;
        }

        if (!from.isEmpty() && to.isEmpty()) {
            return eqSize.equals(from);
        }

        try {
            int eqVal = Integer.parseInt(eqSize);
            int fromVal = Integer.parseInt(from);
            int toVal = Integer.parseInt(to);
            return eqVal >= fromVal && eqVal <= toVal;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public synchronized String reserve(String clientName,
            int equipmentId,
            LocalDate from,
            LocalDate to) {
        if (from.isAfter(to)) {
            return "ERROR: Началната дата е след крайната.";
        }

        Equipment equipment = equipmentMap.get(equipmentId);
        if (equipment == null) {
            return "ERROR: Няма артикул с ID=" + equipmentId;
        }

        for (Reservation existing : reservations.values()) {
            if (existing.getEquipment().getId() == equipmentId) {
                if (periodsOverlap(from, to, existing.getFromDate(), existing.getToDate())) {
                    return "ERROR: Артикул ID=" + equipmentId +
                            " е зает за период " +
                            existing.getFromDate() + " .. " + existing.getToDate();
                }
            }
        }

        long days = java.time.temporal.ChronoUnit.DAYS.between(from, to) + 1;
        if (days <= 0) {
            return "ERROR: Некоректен период.";
        }

        double basePrice = days * equipment.getPricePerDay();
        double totalPrice = basePrice;

        if (days > 5) {
            totalPrice = basePrice * 0.9;
        }

        int resId = nextReservationId.getAndIncrement();
        Reservation reservation = new Reservation(resId, clientName, equipment, from, to, totalPrice);
        reservations.put(resId, reservation);

        return "OK: Създадена резервация " + resId +
                " за артикул ID=" + equipmentId +
                " от " + from.format(dateFormatter) +
                " до " + to.format(dateFormatter) +
                ", дни=" + days +
                ", цена=" + totalPrice;
    }

    private boolean periodsOverlap(LocalDate from1, LocalDate to1,
            LocalDate from2, LocalDate to2) {
        return !(to1.isBefore(from2) || from1.isAfter(to2));
    }

    public synchronized String listReservationsForClient(String clientName) {
        StringBuilder sb = new StringBuilder();
        sb.append("Резервации за: ").append(clientName).append(System.lineSeparator());

        boolean found = false;
        for (Reservation res : reservations.values()) {
            if (res.getClientName().equalsIgnoreCase(clientName)) {
                sb.append(res.toString()).append(System.lineSeparator());
                found = true;
            }
        }

        if (!found) {
            sb.append("Няма резервации.");
        }

        return sb.toString();
    }

    public synchronized String cancelReservation(int reservationId, String clientName) {
        Reservation res = reservations.get(reservationId);
        if (res == null) {
            return "ERROR: Няма резервация с ID=" + reservationId;
        }

        if (!res.getClientName().equalsIgnoreCase(clientName)) {
            return "ERROR: Тази резервация не е на потребител " + clientName;
        }

        reservations.remove(reservationId);
        return "OK: Резервация " + reservationId + " е отменена.";
    }

    public synchronized String listAvailableForDateAsText(LocalDate date) {
        List<Equipment> list = listAvailableForDate(date);
        if (list.isEmpty()) {
            return "Няма налични артикули за дата " + date;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Налични артикули за дата ").append(date).append(":").append(System.lineSeparator());
        for (Equipment eq : list) {
            sb.append(eq.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public synchronized String filterAsText(EquipmentType type, String sizeFrom, String sizeTo) {
        List<Equipment> list = filter(type, sizeFrom, sizeTo);
        if (list.isEmpty()) {
            return "Няма намерени артикули за тип=" + type +
                    " и диапазон размер [" + sizeFrom + ", " + sizeTo + "]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Резултат от филтър тип=").append(type)
                .append(" размер[").append(sizeFrom).append(", ").append(sizeTo).append("]:")
                .append(System.lineSeparator());
        for (Equipment eq : list) {
            sb.append(eq.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
