public class Monitor {
    public static void main(String[] args) throws Exception {
        var server = new WebServer();

        server.addRequest(new WebServer.Request("/home", 200));
        server.addRequest(new WebServer.Request("/login", 404));
        server.addRequest(new WebServer.Request("/profile", 500));
        server.addRequest(new WebServer.Request("/contact", 201));

        server.getRequestStats();
    }
}
