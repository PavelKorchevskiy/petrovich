package com.representation.grpc;

import io.grpc.examples.routeguide.ChatRequest;
import io.grpc.examples.routeguide.ChatResponse;

public interface ChatClientGrps {

    ChatResponse callServer(ChatRequest request);
}
