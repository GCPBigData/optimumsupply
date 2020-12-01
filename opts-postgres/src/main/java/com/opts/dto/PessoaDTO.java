package com.opts.dto;

import com.opts.entity.PessoaEnt;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;
    String nome;
    String cpf;
    LocalDateTime datanascimento;
    String estado;
    String cidade;
    String cep;
    String telefone;
    String email;
    String skype;
    String status;
    LocalDateTime datacadastro = LocalDateTime.now();

    public PessoaDTO(PessoaEnt pessoaEnt) {
        id = pessoaEnt.getId();
        nome = pessoaEnt.getNome();
        cpf = pessoaEnt.getCpf();
        datanascimento = pessoaEnt.getDatanascimento();
        estado = pessoaEnt.getEstado();
        cidade = pessoaEnt.getCidade();
        cep = pessoaEnt.getCep();
        telefone = pessoaEnt.getTelefone();
        email = pessoaEnt.getEmail();
        skype = pessoaEnt.getSkype();
        status = pessoaEnt.getStatus();
        datacadastro = pessoaEnt.getDatacadastro();
    }
}
