package org.andi.dani.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
@Slf4j
@Controller
public class RequestStream {
    @MessageMapping("stream")
    Flux<String> stream() {
        return Flux.just("1", "2", "3");
    }
}
