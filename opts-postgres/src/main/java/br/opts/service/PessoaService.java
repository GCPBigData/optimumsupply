package br.opts.service;

import com.opts.entity.Pessoa;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 02/11/2020
 */

public interface PessoaService {

    Flux<Pessoa> findAll();
    Flux <Pessoa> findByCep(String cep);
    Mono findById(Long id);
    Flux<Pessoa> findByNome(String nome);
    Mono findByCpf(String cpf);
    Mono findBySkype(String skype);
    Mono findByEmail(String email);
    Mono<Pessoa> save(Pessoa pessoa);
    Mono<Pessoa> update(Pessoa pessoa);
    Flux<Pessoa> saveAll(List<Pessoa> pessoas);

}
