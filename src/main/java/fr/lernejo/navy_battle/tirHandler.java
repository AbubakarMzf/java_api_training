package fr.lernejo.navy_battle;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpPrincipal;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

public class tirHandler implements HttpHandler {
    private final Sea sea;
    private int current_cell = 0;

    public tirHandler(Sea sea){
        this.sea = sea;
    }

    private String getCellFromInt() {
        char ligne = (char) ('a' + (this.current_cell % 7));
        int col = this.current_cell / 7 + 1;
        return ligne + String.valueOf(col);
    }

    public void handle(HttpExchange exchange) throws IOException {
        boolean checkV = checkVerb(exchange);
        if (checkVerb(exchange)) {
            try {
                //System.out.println("Bonjour je suis dans tir");
                String cases = this.getQueryMap(exchange.getRequestURI().getQuery());
                String result = sea.checkPosition(cases.charAt(0) - 65 ,(cases.charAt(1) - 1) % 48);
                boolean shipLeft = sea.getSea().size() != 0;
                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, ("{\"consequence\":" + "\"" + result + "\"" + ", \"shipLeft\":" + "\"" + shipLeft + "\"" + "}").length());
                exchange.getResponseBody().write(("{\"consequence\":" + "\"" + result + "\"" + ", \"shipLeft\":" + "\"" + shipLeft + "\"" + "}").getBytes());
                //System.out.println("la : " + getContent(exchange));
                System.out.println("sender " + exchange.getRequestHeaders().get("sender").get(0));
                String body = sendRequestFireClient(exchange.getRequestHeaders().get("sender").get(0), exchange);
                System.out.println("body : " + body);
            }
            catch (Exception e){
                System.out.println("exception : " + e.getMessage());
                exchange.sendResponseHeaders(400, "Erreur".length());
                exchange.getResponseBody().write("Erreur".getBytes());}}
        else {
            exchange.sendResponseHeaders(404, "Erreur".length());
            exchange.getResponseBody().write("Erreur".getBytes());}
        exchange.close();}

    public static String getQueryMap(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map.get("cell");
    }
    public boolean checkVerb(HttpExchange exchange){
        return exchange.getRequestMethod().equals("GET");
    }
    public String sendRequestFireClient(String url, HttpExchange exchange) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requeteGet = HttpRequest.newBuilder()
            .uri(URI.create(url + "/api/game/fire?cell=" + this.getCellFromInt()))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .setHeader("sender", "http://localhost:" + exchange.getLocalAddress().getPort())
            .GET()
            .build();
        System.out.println(this.getCellFromInt());
        this.current_cell++;
        return client.send(requeteGet, HttpResponse.BodyHandlers.ofString()).body();
    }
}
