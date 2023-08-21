package org.andi.dani.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class FireAndForget {
    @MessageMapping("event")
    public Mono<Void> alert(Mono<String> alertMono) {
        return alertMono
                .doOnNext(event ->
                        log.info("Event Id '{}' occurred of type '{}' at '{}'", event))
                .thenEmpty(Mono.empty());
    }
}
