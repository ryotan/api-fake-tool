package kaba.defapi.server;

import org.eclipse.jetty.server.Server;

import kaba.defapi.server.handler.ApiMappingHandler;

/**
 * @author ryotan
 * @since 1.0
 */
public class FakeApiServer {

    public static void main(String... args) throws Exception {
        Server server = new Server(13860);
        server.setHandler(new ApiMappingHandler());
        server.start();
        server.join();
    }
}
