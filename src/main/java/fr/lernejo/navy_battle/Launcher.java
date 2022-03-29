package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {

    public static void main(String[] args) throws IOException {
        try{
            if (args.length > 0) {
                int port = Integer.parseInt(args[0]);
                Server serverClass = new Server();
                HttpServer server = serverClass.createServer(port);
                serverClass.createContext(server);
                if (args.length == 2) {serverClass.initClient(args[1]);}
                server.start();
            }
            else{
                System.out.println("Parameter missing. Enter a port.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid parameter. First parameter should be an integer.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
