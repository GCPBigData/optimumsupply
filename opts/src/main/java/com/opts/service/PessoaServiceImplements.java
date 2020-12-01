package com.opts.service;

import com.opts.documents.PessoaDoc;
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

    @Autowired
    PessoaRepository pessoaRepository;

    public Flux<PessoaDoc> findAll() { return pessoaRepository.findAll(); }
    public Flux<PessoaDoc> searchNome(String nome) { return pessoaRepository.searchNome(nome); }
    public Flux<PessoaDoc> fullSearch(String nome, String cpf, String skype, String email, String cep) { return pessoaRepository.fullSearch(nome, cpf, skype, email, cep); }
    public Flux<PessoaDoc> findByCep(String cep) { return pessoaRepository.findByCep(cep); }
    public Mono<PessoaDoc> findById(String id) {
        return pessoaRepository.findById(id);
    }
    public Mono<PessoaDoc> save(PessoaDoc pessoaDoc) {
        return pessoaRepository.save(pessoaDoc);
    }
    public Mono<PessoaDoc> update(PessoaDoc pessoaDoc) {
        return pessoaRepository.save(pessoaDoc);
    }
    public Mono<PessoaDoc> findByNome(String nome) { return pessoaRepository.findByNome(nome); }
    public Mono<PessoaDoc> findByEmail(String email) { return pessoaRepository.findByEmail(email); }
    public Mono<PessoaDoc> findByCpf(String cpf) { return pessoaRepository.findByCpf(cpf); }
    public Mono<PessoaDoc> findBySkype(String skype) { return pessoaRepository.findBySkype(skype); }


}
