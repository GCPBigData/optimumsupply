package br.caed.service;

import br.caed.repository.PessoaRepository;
import com.opts.entity.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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

    public Flux<Pessoa> findAll() { return pessoaRepository.findAll(); }

    @Override
    public Flux<Pessoa> findByCep(String cep) {
        return null;
    }

    @Override
    public Mono findById(Long id) {
        return null;
    }

    @Override
    public Mono findByNome(String nome) {
        return null;
    }

    @Override
    public Mono findByCpf(String cpf) {
        return null;
    }

    @Override
    public Mono findBySkype(String skype) {
        return null;
    }

    @Override
    public Mono findByEmail(String email) {
        return null;
    }

    @Override
    public Mono<Pessoa> save(Pessoa pessoa) {
        return null;
    }

    @Override
    public Mono<Pessoa> update(Pessoa pessoa) {
        return null;
    }

    @Override
    public Flux<Pessoa> saveAll(List<Pessoa> pessoas) {
        return null;
    }
    /*public Flux<PessoaEnt> findByCep(String cep) { return pessoaRepository.findByCep(cep); }
    public Mono<PessoaEnt> findById(String id) {
        return pessoaRepository.findById(id);
    }
    public Mono<PessoaEnt> save(PessoaEnt pessoaDoc) {
        return pessoaRepository.save(pessoaDoc);
    }
    public Mono<PessoaEnt> update(PessoaEnt pessoaDoc) {
        return pessoaRepository.save(pessoaDoc);
    }
    public Mono<PessoaEnt> findByNome(String nome) { return pessoaRepository.findByNome(nome); }
    public Mono<PessoaEnt> findByEmail(String email) { return pessoaRepository.findByEmail(email); }
    public Mono<PessoaEnt> findByCpf(String cpf) { return pessoaRepository.findByCpf(cpf); }
    public Mono<PessoaEnt> findBySkype(String skype) { return pessoaRepository.findBySkype(skype); }
*/

}
