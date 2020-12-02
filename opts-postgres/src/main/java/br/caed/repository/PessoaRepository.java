package br.caed.repository;

import com.opts.entity.Pessoa;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PessoaRepository extends ReactiveCrudRepository<Pessoa, Long> {
    Mono<Pessoa> findById(long id);
    Flux<Pessoa> findByNome(String nome);
    Mono<Pessoa> findByCpf(String cpf);
    Mono<Pessoa> findBySkype(String skype);
    Mono<Pessoa> findByEmail(String email);
    Flux<Pessoa> findByCep(String cep);
}
