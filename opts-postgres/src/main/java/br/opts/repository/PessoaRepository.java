package br.opts.repository;

import com.opts.entity.Pessoa;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 02/11/2020
 */

public interface PessoaRepository extends ReactiveCrudRepository<Pessoa, Long> {
    Mono<Pessoa> findById(Long id);
    Flux<Pessoa> findByNome(String nome);
    Mono<Pessoa> findByCpf(String cpf);
    Mono<Pessoa> findBySkype(String skype);
    Mono<Pessoa> findByEmail(String email);
    Flux<Pessoa> findByCep(String cep);
}
