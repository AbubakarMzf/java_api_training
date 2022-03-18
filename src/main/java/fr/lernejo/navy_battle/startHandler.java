package fr.lernejo.navy_battle;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.*;

import java.nio.charset.StandardCharsets;


public class startHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (checkVerb(exchange)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                InputStream fileInputStream = exchange.getRequestBody();
                String body = new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8);
                StartSchema startSchema = objectMapper.readValue(body, StartSchema.class);
                response(startSchema, exchange);
            }
            catch (Exception e){
                exchange.sendResponseHeaders(404 - 4, "Erreur".length());
                exchange.getResponseBody().write("Erreur".getBytes());;
            }
        }
        else {
            exchange.sendResponseHeaders(404, "Erreur".length());
            exchange.getResponseBody().write("Erreur".getBytes());
        }
        exchange.close();
    }

    public void response(StartSchema startSchema, HttpExchange exchange) throws  IOException{
        if (startSchema.isValid()) {
            exchange.sendResponseHeaders(200, startSchema.toString().length());
            exchange.getResponseBody().write(startSchema.toString().getBytes());
        }
        else {
            exchange.sendResponseHeaders(400, "Erreur".length());
            exchange.getResponseBody().write("Erreur".getBytes());
        }
    }

    public boolean checkVerb(HttpExchange exchange){
        if (exchange.getRequestMethod().equals("POST")) {
            return true;
        }
        return false;
    }
}



