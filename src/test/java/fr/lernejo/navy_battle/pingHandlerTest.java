package fr.lernejo.navy_battle;
import com.sun.net.httpserver.HttpServer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class pingHandlerTest {
    @Test
    void test_route_ping() {
        try {
            Server serverClass = new Server(5000);
            HttpServer server = serverClass.createServer(serverClass);
            server.start();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:5000/ping"))
                .GET()
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Assertions.assertThat(response.statusCode()).isEqualTo(404);
        }catch(Exception e) {}
    }
}
