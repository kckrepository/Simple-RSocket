package org.andi.dani.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class RequestResponse {
    @MessageMapping("hello")
    Mono<String> ping(Mono<String> message) {
        log.info("@MessageMapping(hello), payload : {}", message);
        return Mono.just("received (" + message + ") at " + LocalDateTime.now());
    }
}
