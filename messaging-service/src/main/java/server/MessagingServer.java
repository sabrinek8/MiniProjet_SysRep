package server;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagingServer {
    private final int port;
    private final Server server;

    public MessagingServer(int port) {
        this.port = port;
        this.server = ServerBuilder.forPort(port).addService(new MessagingServiceImpl()).build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server since JVM is shutting down");
            MessagingServer.this.stop();
            System.err.println("Server shut down");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MessagingServer server = new MessagingServer(50051);
        server.start();
        server.blockUntilShutdown();
    }
}

   
