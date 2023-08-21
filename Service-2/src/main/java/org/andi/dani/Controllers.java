package org.andi.dani;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController()
@RequiredArgsConstructor
public class Controllers {
    private final RSocketRequester requester;

    @GetMapping("hello")
    Mono<String> hello() {
        return requester.route("hello").data("Hello RSocket").retrieveMono(String.class);
    }

    @GetMapping("stream")
    Flux<String> stream() {
        return requester.route("stream").data("").retrieveFlux(String.class);
    }

    @GetMapping("fire")
    void fire() {
        requester.route("event").data("fire and forget").send().subscribe();
    }

    @GetMapping("channel")
    Flux<String> channel() {
        var data = Flux.just("a", "b", "c", "d");

        return requester.route("channel")
                .data(data)
                .retrieveFlux(String.class);
    }
}