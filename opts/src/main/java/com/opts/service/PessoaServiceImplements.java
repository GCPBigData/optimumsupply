package com.opts.service;

import com.opts.documents.PessoaDoc;
import com.opts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

@Service
public class PessoaServiceImplements implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Flux<PessoaDoc> findAll() {
        return pessoaRepository.findAll();
    }
    public Mono<PessoaDoc> findById(String id) {
        return pessoaRepository.findById(id);
    }
    public Mono<PessoaDoc> save(PessoaDoc pessoaDoc) {
        return pessoaRepository.save(pessoaDoc);
    }
    public Mono<PessoaDoc> update(PessoaDoc pessoaDoc) {
        return pessoaRepository.save(pessoaDoc);
    }
}
