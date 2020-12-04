package com.opts.repository;

import com.opts.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNome(String nome);
    List<Pessoa> findByCpf(String cpf);
    List<Pessoa> findByCep(String cep);
}
