package com.opts.controller;

import com.opts.documents.PessoaDoc;
import com.opts.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

@RestController
@RequestMapping(value = "/pessoa/v1/")
@Api(value = "API REST pessoa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {

  /*  @Autowired
    PessoaService pessoaService;

    @GetMapping(value = "/listaTodo")
    public Flux<PessoaDoc> getAll() {
        return pessoaService.findAll();
    }

    @GetMapping(value = "/buscarId/{id}")
    public Mono<PessoaDoc> getById(@PathVariable String id) {
        return pessoaService.findById(id)
                .map(pessoaDoc -> ResponseEntity.ok(pessoaDoc))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }*/

}
