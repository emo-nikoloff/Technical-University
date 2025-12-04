/*Разработете клас WebServer, който съдържа вложен клас Request. Класът Request трябва да управлява информация за заявки към сървъра, включително URL и статус код. WebServer трябва да управлява
списък от заявки и да предоставя статистика за тях.
Пример:
var server = new WebServer();
server.addRequest(new WebServer.Request("/home", 200));
server.getRequestStats();*/

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
