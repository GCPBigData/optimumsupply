package com.opts.service;

import com.opts.model.Pessoa;
import com.opts.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> findByNome(String nome){ return pessoaRepository.findByNome(nome); }
    public List<Pessoa> findByCpf(String cpf){ return pessoaRepository.findByCpf(cpf); }
    public List<Pessoa> findByCep(String cep){ return pessoaRepository.findByCep(cep); }
    public List<Pessoa> findAll(){ return (List<Pessoa>) pessoaRepository.findAll(); }
    public Pessoa save(Pessoa pessoa) { return pessoaRepository.save(pessoa); }
    public Pessoa update(Pessoa pessoa) { return pessoaRepository.save(pessoa); }
    public Pessoa findById(Long id) { return pessoaRepository.findById(id).get(); }
}
