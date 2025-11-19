import java.util.ArrayList;
import java.util.List;

public class WebServer {

    public static class Request {
        private String url;
        private int statusCode;

        public Request(String url, int statusCode) {
            this.url = url;
            this.statusCode = statusCode;
        }

        public String getUrl() {
            return url;
        }

        public int getStatusCode() {
            return statusCode;
        }
    }

    private List<Request> requests = new ArrayList<>();

    public void addRequest(Request request) {
        requests.add(request);
    }

    public void getRequestStats() {
        System.out.println("=== Request Statistics ===");
        System.out.println("Total requests: " + requests.size());

        int successful = 0;
        int errors = 0;

        for (Request request : requests) {
            if (request.getStatusCode() >= 200 && request.getStatusCode() < 300) {
                successful++;
            } else {
                errors++;
            }
        }

        System.out.println("Successful (2xx): " + successful);
        System.out.println("Errors (!2xx): " + errors);
    }
}
