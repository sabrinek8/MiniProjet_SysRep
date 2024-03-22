package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Iterator;

public class MessagingClient {
    private final ManagedChannel channel;
    private final MessagingServiceGrpc.MessagingServiceBlockingStub blockingStub;

    public MessagingClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = MessagingServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void sendMessage(String sender, String receiver, String message) {
        MessageRequest request = MessageRequest.newBuilder()
                .setSender(sender)
                .setReceiver(receiver)
                .setMessage(message)
                .build();
        blockingStub.sendMessage(request);
    }

    public void receiveMessages(String user) {
        UserRequest request = UserRequest.newBuilder().setUser(user).build();
        Iterator<MessageResponse> responses = blockingStub.receiveMessages(request);
        while (responses.hasNext()) {
            MessageResponse response = responses.next();
            for (String message : response.getMessagesList()) {
                System.out.println(message);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MessagingClient client = new MessagingClient("localhost", 50051);
        try {
            client.sendMessage("Alice", "Bob", "Hello Bob!");
            client.sendMessage("Bob", "Alice", "Hi Alice!");
            client.receiveMessages("Bob");
        } finally {
            client.shutdown();
        }
    }
}
