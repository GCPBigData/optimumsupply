package com.opts.repository;

import com.opts.documents.PessoaDoc;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

public interface PessoaRepository extends ReactiveMongoRepository<PessoaDoc, String> {

    Mono<PessoaDoc> findByNome(String nome);
    Mono<PessoaDoc> findByCpf(String cpf);
    Mono<PessoaDoc> findBySkype(String skype);
    Mono<PessoaDoc> findByEmail(String email);

    @Query("{'nome':{$regex:?0,$options:'i'}}")
    Flux<PessoaDoc> searchNome(String nome);

    @Query("{$or:[{'nome':{$regex:?0,$options:'i'}}," +
            "{'cpf':{$regex:?0,$options:'i'}}]}," +
            "{'skype':{$regex:?0,$options:'i'}}]}, " +
            "{'email':{$regex:?0,$options:'i'}}]}, ")
    Flux<PessoaDoc> fullSearch(String nome, String cpf, String skype, String email);

}
