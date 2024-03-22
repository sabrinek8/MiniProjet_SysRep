package server.copy;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.grpc.MessageRequest;
import com.example.grpc.MessageResponse;
import com.example.grpc.MessagingServiceGrpc.MessagingServiceImplBase;
import com.example.grpc.UserRequest;
static class MessagingServiceImpl extends MessagingServiceImplBase.MessagingServiceImplBase {
    private Map<String, List<String>> userMessages = new HashMap<>();

    
    public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        String receiver = request.getReceiver();
        String message = request.getMessage();
        if (!userMessages.containsKey(receiver)) {
            userMessages.put(receiver, new ArrayList<>());
        }
        userMessages.get(receiver).add(request.getSender() + ": " + message);
        MessageResponse response = MessageResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void receiveMessages(UserRequest request, StreamObserver<MessageResponse> responseObserver) {
        String user = request.getUser();
        List<String> messages = userMessages.getOrDefault(user, Collections.emptyList());
        MessageResponse response = MessageResponse.newBuilder().addAllMessages(messages).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
