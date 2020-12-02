package br.opts.service;

import br.opts.repository.PessoaRepository;
import com.opts.entity.Pessoa;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class PessoaServiceImplements implements PessoaService {

    PessoaRepository pessoaRepository;

    @Override
    public Flux<Pessoa> findAll() {
        return pessoaRepository.findAll()
                .switchIfEmpty(monoResponseStatusNotFoundException()); }

    @Override
    public Flux<Pessoa> findByCep(String cep) {
        return pessoaRepository.findByCep(cep)
                .switchIfEmpty(monoResponseStatusNotFoundException()); }

    @Override
    public Mono findById(Long id) {
        return pessoaRepository.findById(id)
            .switchIfEmpty(monoResponseStatusNotFoundException()); }

     @Override
     public Flux<Pessoa> findByNome(String nome) {
         return pessoaRepository.findByNome(nome)
                 .switchIfEmpty(monoResponseStatusNotFoundException());
     }

    @Override
    public Mono<Pessoa> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf)
                .switchIfEmpty(monoResponseStatusNotFoundException()); }

    @Override
    public Mono<Pessoa> findBySkype(String skype) {
        return pessoaRepository.findBySkype(skype)
                .switchIfEmpty(monoResponseStatusNotFoundException()); }

    @Override
    public Mono<Pessoa> findByEmail(String email) {
        return pessoaRepository.findByEmail(email)
                .switchIfEmpty(monoResponseStatusNotFoundException()); }

    @Override
    public Mono<Pessoa> save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Mono<Pessoa> update(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Flux<Pessoa> saveAll(List<Pessoa> pessoas) {
        return pessoaRepository.saveAll(pessoas);
    }

    private void throwResponseStatusExceptionWhenEmptyName(Pessoa Pessoa){
        if(StringUtil.isNullOrEmpty(Pessoa.getNome())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Name");
        }
    }

    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa not found"));
    }

}
