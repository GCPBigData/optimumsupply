package com.opts.repository;

import com.opts.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 02/11/2020
 */

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNome(String nome);
    List<Pessoa> findByCpf(String cpf);
    List<Pessoa> findByCep(String cep);
}
