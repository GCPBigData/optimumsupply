package com.opts.service;

import com.opts.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PessoaService {
    List<Pessoa> findAll();
    Pessoa findById(Long id);
    List<Pessoa> findByNome(String nome);
    List<Pessoa> findByCep(String cep);
    List<Pessoa> findByCpf(String cpf);
    Pessoa save(Pessoa pessoa);
    Pessoa update(Pessoa pessoa);

}
