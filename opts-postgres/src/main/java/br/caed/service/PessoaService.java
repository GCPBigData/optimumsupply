package br.caed.service;

import com.opts.entity.Pessoa;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PessoaService {

    Flux<Pessoa> findAll();
    Flux <Pessoa> findByCep(String cep);
    Mono findById(Long id);
    Mono findByNome(String nome);
    Mono findByCpf(String cpf);
    Mono findBySkype(String skype);
    Mono findByEmail(String email);
    Mono<Pessoa> save(Pessoa pessoa);
    Mono<Pessoa> update(Pessoa pessoa);
    Flux<Pessoa> saveAll(List<Pessoa> pessoas);

   /* private PessoaRepository PessoaRepository;

    public Flux<Pessoa> findAll() {
        return PessoaRepository.findAll();
    }

    public Mono<Pessoa> findById(long id) {
        return PessoaRepository.findById(id)
                .switchIfEmpty(monoResponseStatusNotFoundException());
    }

    public Mono<Pessoa> save(Pessoa Pessoa) {
        return PessoaRepository.save(Pessoa);
    }

    @Transactional
    public Flux<Pessoa> saveAll(List<Pessoa> Pessoas) {
        return PessoaRepository.saveAll(Pessoas)
                .doOnNext(this::throwResponseStatusExceptionWhenEmptyName);
    }

    public Mono<Void> update(Pessoa Pessoa) {
        return findById(Pessoa.getId())
                .flatMap(PessoaRepository::save)
                .then();
    }

    public Mono<Void> delete(int id) {
        return findById(id)
                .flatMap(PessoaRepository::delete);
    }

    private void throwResponseStatusExceptionWhenEmptyName(Pessoa Pessoa){
        if(StringUtil.isNullOrEmpty(Pessoa.getNome())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Name");
        }
    }

    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa not found"));
    }*/
}
