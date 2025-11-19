public class Journal {
    public static void main(String[] args) throws Exception {
        var log = new EventLog();

        log.addEvent("2023-01-01", "Нова година");
        log.addEvent("2023-03-10", "Рожден ден");
        log.addEvent("2023-06-15", "Край на срока");

        var filteredEvents = log.getEventsBetween("2023-01-01", "2023-06-01");

        for (var event : filteredEvents) {
            System.out.println(event);
        }
    }
}
