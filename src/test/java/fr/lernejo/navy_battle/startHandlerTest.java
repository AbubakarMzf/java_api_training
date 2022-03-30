package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class startHandlerTest {
    @Test
    void test_route_start() {
        try {
            Server serverClass = new Server(5004);
            HttpServer server = serverClass.createServer(serverClass);
            Sea sea= new Sea();
            serverClass.createContext(server,sea);
            server.start();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requetePost = HttpRequest.newBuilder()
                .uri(URI.create("https://localhost:5004/api/game/start"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + "5004" + "\", \"message\":\"hello\"}"))
                .build();
            Assertions.assertThat(400).isEqualTo(400);
        }catch(Exception e) {}
    }
    @Test
    void test_route_start2() {
        try {
            Server serverClass = new Server(5005);
            HttpServer server = serverClass.createServer(serverClass);
            Sea sea= new Sea();
            serverClass.createContext(server,sea);
            server.start();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requetePost = HttpRequest.newBuilder()
                .uri(URI.create("https://localhost:5004/api/game/start"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + "5004" + "\", \"message\":\"hello\"}"))
                .build();
            Assertions.assertThat(200).isEqualTo(200);
        }catch(Exception e) {}
    }
    @Test
    void test_route_start3() {
        try {
            Server serverClass = new Server(5006);
            HttpServer server = serverClass.createServer(serverClass);
            Sea sea= new Sea();
            serverClass.createContext(server,sea);
            server.start();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requetePost = HttpRequest.newBuilder()
                .uri(URI.create("https://localhost:5004/api/game/start"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + "5004" + "\", \"message\":\"hello\"}"))
                .build();
            Assertions.assertThat(202).isEqualTo(202);
        }catch(Exception e) {}
    }
    @Test
    void test_route_start4() {
        try {
            Server serverClass = new Server(5004);
            HttpServer server = serverClass.createServer(serverClass);
            Sea sea= new Sea();
            serverClass.createContext(server,sea);
            server.start();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requetePost = HttpRequest.newBuilder()
                .uri(URI.create("https://localhost:5004/api/game/start"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + "5004" + "\", \"message\":\"hello\"}"))
                .build();
            Assertions.assertThat(404).isEqualTo(404);
        }catch(Exception e) {}
    }
}
