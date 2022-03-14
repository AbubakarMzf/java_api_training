package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {

    public static void main(String[] args) throws IOException {
        InetSocketAddress addr = new InetSocketAddress(5000);
        HttpServer server = HttpServer.create(addr, 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new pingHandler());
        server.start();
    }
}
