import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventLog {

    private static class Event {
        private LocalDate date;
        private String description;

        public Event(LocalDate date, String description) {
            this.date = date;
            this.description = description;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }
    }

    private List<Event> events = new ArrayList<>();

    public void addEvent(String date, String description) {
        LocalDate eventDate = LocalDate.parse(date);
        events.add(new Event(eventDate, description));
        events.sort((a, b) -> a.getDate().compareTo(b.getDate()));
    }

    public List<String> getEventsBetween(String start, String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        List<String> result = new ArrayList<>();

        for (Event e : events) {
            if (!e.getDate().isBefore(startDate) && !e.getDate().isAfter(endDate)) {
                result.add(e.getDate() + " - " + e.getDescription());
            }
        }

        return result;
    }
}
