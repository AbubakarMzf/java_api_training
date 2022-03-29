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
    private int port;
    public HttpServer createServer(int port) throws IOException {
        this.port = port;
        InetSocketAddress addr = new InetSocketAddress(port);
        HttpServer server = HttpServer.create(addr, 0);
        return server;
    }

    public void createContext(HttpServer server) throws IOException {
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new pingHandler());
        server.createContext("/api/game/start", new startHandler());
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
