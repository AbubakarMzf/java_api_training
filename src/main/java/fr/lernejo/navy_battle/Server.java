package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {

    public HttpServer createServer(int port) throws IOException {
        InetSocketAddress addr = new InetSocketAddress(port);
        HttpServer server = HttpServer.create(addr, 0);
        return server;
    }

    public void createContext(HttpServer server) throws IOException {
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new pingHandler());
        server.createContext("/api/game/start", new startHandler());
    }
}
