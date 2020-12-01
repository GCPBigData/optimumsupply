package com.opts.service;

import com.opts.entity.PessoaEnt;
import com.opts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

@Service
public class PessoaServiceImplements implements PessoaService {

    PessoaRepository pessoaRepository;

    public Flux<PessoaEnt> findAll() { return pessoaRepository.findAll(); }
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
