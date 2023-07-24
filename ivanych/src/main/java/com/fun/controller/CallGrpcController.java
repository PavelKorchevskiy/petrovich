package com.fun.controller;

import com.fun.grpc.ChatClientGrps;
import io.grpc.examples.routeguide.ChatRequest;
import io.grpc.examples.routeguide.ChatResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("grpc/")
@AllArgsConstructor
public class CallGrpcController {

    private ChatClientGrps chatClientGrps;

    @GetMapping("chat")
    public void callGrpcService(@RequestBody String message) {
        List<Integer> numbers = message.chars().mapToObj(c -> (int) c).collect(Collectors.toList());
        ChatRequest chatRequest = ChatRequest.newBuilder().setName(message).addAllNumbers(numbers).build();
        ChatResponse chatResponse = chatClientGrps.callServer(chatRequest);
        System.out.println("Response from gRPC service: " + chatResponse.getMessage());
    }



}
