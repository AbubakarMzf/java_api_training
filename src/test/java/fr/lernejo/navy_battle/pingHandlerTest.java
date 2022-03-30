package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

class pingHandlerTest {

    private HttpResponse<String> response;

    void setForGoodRequest() throws  InterruptedException, IOException {
        Server serverClass = new Server(5000);
        HttpServer server = serverClass.createServer(serverClass);
        server.start();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:5000/ping"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .GET()
            .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        server.stop(1);
    }
    @Test
    void test_good_ping() {
        int result = response.statusCode();
        Assertions.assertThat(result).as("Code 200.").isEqualTo(HttpURLConnection.HTTP_OK);
    }
    void setForBadRequest() throws  InterruptedException, IOException {
        Server serverClass = new Server(5000);
        HttpServer server = serverClass.createServer(serverClass);
        server.start();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:5000/api/ping"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .GET()
            .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        server.stop(1);
    }

    @Test
    void test_bad_ping() {
        int result = response.statusCode();
        Assertions.assertThat(result).as("Code 404.").isEqualTo(HttpURLConnection.HTTP_NOT_FOUND);
    }

}
