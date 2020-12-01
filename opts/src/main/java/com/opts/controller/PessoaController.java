package com.opts.controller;

import com.opts.documents.PessoaDoc;
import com.opts.dto.PessoaDTO;
import com.opts.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    PessoaService pessoaService;

    @GetMapping(value = "/listarTodos")
    public Flux<PessoaDoc> getAll() {
        return pessoaService.findAll();
    }

    @GetMapping(value = "/buscarId/{id}")
    public Mono<PessoaDoc> getById(@PathVariable String id) {
        return pessoaService.findById(id)
                .map(pessoaDoc -> ResponseEntity.ok(pessoaDoc))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/buscarCpf/{cpf}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Mono<PessoaDoc> getByCpf(@PathVariable String cpf) {
        Mono<PessoaDoc> resultMono = pessoaService.findByCpf(cpf);
        return resultMono;
    }

    @RequestMapping(value="/buscarCep/{cep}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PessoaDTO>> getByCep(@PathVariable String cep) {
        Flux<PessoaDoc> listFlux = pessoaService.findAll();
        List<PessoaDTO> listDto = listFlux.toStream()
                .map(PessoaDTO::new)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/buscarNome/{nome}", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PessoaDTO>> getByNome(@PathVariable String nome) {
        Flux<PessoaDoc> listFlux = pessoaService.findAll();
        List<PessoaDTO> listDto = listFlux.toStream()
                .sorted(Comparator.comparing(PessoaDoc::getId).reversed())
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(PessoaDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/flux20Ativos", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PessoaDTO>> findAllAtivos() {
        Flux<PessoaDoc> listFlux = pessoaService.findAll();
        List<PessoaDTO> listDto = listFlux.toStream()
                .sorted(Comparator.comparing(PessoaDoc::getId).reversed())
                .filter(c -> c.getStatus().equals("Ativo"))
                .map(PessoaDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/flux20Inativo", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PessoaDTO>> findAllInativos() {
        Flux<PessoaDoc> listFlux = pessoaService.findAll();
        List<PessoaDTO> listDto = listFlux.toStream()
                .sorted(Comparator.comparing(PessoaDoc::getId).reversed())
                .filter(c -> c.getStatus().equals("Inativo"))
                .map(PessoaDTO::new)
                .limit(20)
                .collect( Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping(value = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PessoaDoc> save(@Validated @RequestBody PessoaDoc pessoaDoc) {
        return pessoaService.save(pessoaDoc);
    }

    @GetMapping(value = "/status", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PessoaDoc> streamPessoaStatus() {
        return pessoaService.findAll().delayElements(Duration.ofSeconds(1));
    }
}
