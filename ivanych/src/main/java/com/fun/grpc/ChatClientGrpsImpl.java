package com.fun.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.routeguide.ChatRequest;
import io.grpc.examples.routeguide.ChatResponse;
import io.grpc.examples.routeguide.ChatServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ChatClientGrpsImpl implements ChatClientGrps {

    @GrpcClient("chat")
    private ChatServiceGrpc.ChatServiceBlockingStub stub;

    @Override
    public ChatResponse callServer(ChatRequest request) {
        return stub.chat(request);
    }
}
