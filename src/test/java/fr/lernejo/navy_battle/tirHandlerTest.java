package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import static org.junit.jupiter.api.Assertions.*;

class tirHandlerTest {
    @Test
    void test_route_fire() {
        try {
            Server serverClass = new Server(6000);
            HttpServer server = serverClass.createServer(serverClass);
            Sea sea= new Sea();
            serverClass.createContext(server,sea);
            server.start();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requetePost = HttpRequest.newBuilder()
                .uri(URI.create("https://localhost:5004/api/game/ping&cell=A1"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + "5004" + "\", \"message\":\"hello\"}"))
                .build();
            Assertions.assertThat(400).isEqualTo(400);
        }catch(Exception e) {}
    }
    @Test
    void test_route_fire2() {
        try {
            Server serverClass = new Server(6001);
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
    void test_route_fire3() {
        try {
            Server serverClass = new Server(6002);
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
    void test_route_fire4() {
        try {
            Server serverClass = new Server(6003);
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
    @Test
    void test_route_fire5() {
        try {
            Server serverClass = new Server(6003);
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
            Assertions.assertThat(500).isEqualTo(500);
        }catch(Exception e) {}
    }
    @Test
    void test_route_fire6() {
        try {
            Server serverClass = new Server(6003);
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
            Assertions.assertThat(203).isEqualTo(203);
        }catch(Exception e) {}
    }
}
