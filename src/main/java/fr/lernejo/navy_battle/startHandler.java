package fr.lernejo.navy_battle;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class startHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (checkVerb(exchange)) {
            try {
                System.out.println("dans start");
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                InputStream fileInputStream = exchange.getRequestBody();
                String body = new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8);
                StartSchema startSchema = objectMapper.readValue(body, StartSchema.class);
                startSchema.setUrl("http://localhost:" + exchange.getLocalAddress().getPort() + exchange.getRequestURI().toString());
                System.out.println("starthandl : " + getContent(exchange));
                response(startSchema, exchange);
                System.out.println("sender " + exchange.getRequestHeaders().get("sender").get(0));
                responseToClient(exchange.getRequestHeaders().get("sender").get(0), exchange);
                //if (exchange.getRequestHeaders().get("sender") != null) {responseToClient(exchange.getRequestHeaders().get("sender").get(0), exchange);}
            }
            catch (Exception e){exchange.sendResponseHeaders(404, "Erreur".length());exchange.getResponseBody().write("Erreur".getBytes());}}
        else {exchange.sendResponseHeaders(404, "Erreur".length());exchange.getResponseBody().write("Erreur".getBytes());}
        exchange.close();}

    public void response(StartSchema startSchema, HttpExchange exchange) throws  IOException{
        if (startSchema.isValid()) {
            exchange.sendResponseHeaders(202, startSchema.toString().length());
            exchange.getResponseBody().write(startSchema.toString().getBytes());
        }
        else {
            exchange.sendResponseHeaders(400, "Erreur".length());
            exchange.getResponseBody().write("Erreur".getBytes());}
    }
    public HttpResponse<String> responseToClient(String url, HttpExchange exchange) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requeteGet = HttpRequest.newBuilder()
            .uri(URI.create(url + "/api/game/fire?cell=F2"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .setHeader("sender", "http://localhost:" + exchange.getLocalAddress().getPort())
            .GET()
            .build();
        return client.send(requeteGet, HttpResponse.BodyHandlers.ofString());
    }

    public boolean checkVerb(HttpExchange exchange){
        return exchange.getRequestMethod().equals("POST");
    }
    private String getContent(HttpExchange exchange) throws IOException {
        /*
         * It would be nice to not assume UTF8 below, but I don't know how to do
         * that. Maybe escaping is actually done with HTML escapes. I should
         * read up on this. For now I leave it like this.
         */

        BufferedReader httpInput = new BufferedReader(new InputStreamReader(
            exchange.getRequestBody(), "UTF-8"));
        StringBuilder in = new StringBuilder();
        String input;
        while ((input = httpInput.readLine()) != null) {
            in.append(input).append(" ");
        }
        httpInput.close();
        return in.toString().trim();
    }
}



