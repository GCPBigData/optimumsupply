package com.opts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 30/11/2020
 */

@RestController
public class FallbackController {

    @RequestMapping("/pessoaFallBack")
    public Mono<String> pessoaServiceFallBack() {
        return Mono.just("! Pessoa stá demorando muito para responder ou está inativo. Por favor, tente novamente mais tarde");
    }
}
