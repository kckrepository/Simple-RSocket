package org.andi.dani.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class Channel {
    @MessageMapping("channel")
    Flux<String> rSocketChannel(Flux<String> inDatas) {
        return inDatas
                .index()
                .flatMap(data -> {
            return Mono.just("rSocketChannel-" +data.getT1()+ " : " + data.getT2() + " ");
        });
    }
}
