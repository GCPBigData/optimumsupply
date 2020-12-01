package com.opts.service;

import com.opts.entity.PessoaEnt;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

public interface PessoaService {

    Flux <PessoaEnt> findAll();
   /* Flux <PessoaEnt> findByCep(String cep);
    Mono findById(String id);
    Mono findByNome(String nome);
    Mono findByCpf(String cpf);
    Mono findBySkype(String skype);
    Mono findByEmail(String email);
    Mono<PessoaEnt> save(PessoaEnt pessoaEnt);
    Mono<PessoaEnt> update(PessoaEnt pessoaEnt);*/

}
