package com.opts.repository;

import com.opts.entity.PessoaEnt;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

public interface PessoaRepository extends ReactiveCrudRepository<PessoaEnt, String> {

   /* Mono<PessoaEnt> findByNome(String nome);
    Mono<PessoaEnt> findByCpf(String cpf);
    Mono<PessoaEnt> findBySkype(String skype);
    Mono<PessoaEnt> findByEmail(String email);
    Flux<PessoaEnt> findByCep(String cep);*/
}
