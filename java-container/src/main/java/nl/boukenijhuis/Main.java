package nl.boukenijhuis;

import com.sun.net.httpserver.HttpServer;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {

        // scaleway needs a way to check the health of the container
        final HttpServer server = createHttpServerWithHealthEndpoint();
        server.start();

        Checker checker = new Checker();
        checker.checkSolarPanels();

        // stop the server (health endpoint)
//        server.stop(0);
    }

    @NotNull
    private static HttpServer createHttpServerWithHealthEndpoint() throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/health", t -> {
            String response = "The solar-panel-checker is running";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        return server;
    }
}

