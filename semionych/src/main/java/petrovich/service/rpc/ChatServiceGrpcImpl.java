package petrovich.service.rpc;

import io.grpc.examples.routeguide.ChatResponse;
import io.grpc.examples.routeguide.ChatServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ChatServiceGrpcImpl extends ChatServiceGrpc.ChatServiceImplBase {

    @Override
    public void chat(io.grpc.examples.routeguide.ChatRequest request, StreamObserver<io.grpc.examples.routeguide.ChatResponse> responseObserver) {
        System.out.println("ChatServiceGrpcImpl request: name - " + request.getName() + ", numbers - " + request.getNumbersList());
        responseObserver.onNext(ChatResponse.newBuilder().setMessage("name - " + request.getName() + ", numbers - " + request.getNumbersList()).build());
        responseObserver.onCompleted();
    }
}
