package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executors;

public class Server {
    private final int port;
    public Server(int port){
        this.port = port;
    }
    public HttpServer createServer(Server serverClass) throws IOException {
        InetSocketAddress addr = new InetSocketAddress(this.port);
        return HttpServer.create(addr, 0);
    }

    public void createContext(HttpServer server, Sea sea) throws IOException {
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new pingHandler());
        server.createContext("/api/game/start", new startHandler());
        server.createContext("/api/game/fire", new tirHandler(sea));
    }

    public HttpResponse<String> initClient(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requetePost = HttpRequest.newBuilder()
            .uri(URI.create(url + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}"))
            .build();
        return client.send(requetePost, HttpResponse.BodyHandlers.ofString());
    }
}
