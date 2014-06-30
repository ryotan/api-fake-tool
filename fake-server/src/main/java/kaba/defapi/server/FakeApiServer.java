package kaba.defapi.server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * @author ryotan
 * @since 1.0
 */
public class FakeApiServer {

    public static void main(String... args) throws Exception {
        Server server = new Server(13860);
        server.setHandler(new AbstractHandler() {
            @Override
            public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
                    throws IOException, ServletException {
                response.setContentType("text/plain");
                PrintWriter writer = response.getWriter();
                writer.println("target: " + target);
                writer.println("Request: " + baseRequest);
                writer.flush();
            }
        });
        server.start();
        server.join();
    }
}
