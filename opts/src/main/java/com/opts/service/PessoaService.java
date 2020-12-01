package com.opts.service;

import com.opts.documents.PessoaDoc;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

public interface PessoaService {

    Flux <PessoaDoc> findAll();
    Flux <PessoaDoc> searchNome(String nome);
    Flux <PessoaDoc> fullSearch(String nome, String cpf, String skype, String email);
    Mono findById(String id);
    Mono findByNome(String nome);
    Mono findByCpf(String cpf);
    Mono findBySkype(String skype);
    Mono findByEmail(String nome);
    Mono<PessoaDoc> save(PessoaDoc pessoaDoc);
    Mono<PessoaDoc> update(PessoaDoc pessoaDoc);

}
