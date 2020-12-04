package com.opts.DTO;

import com.opts.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
@Data
public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cpf;
    private LocalDateTime datanascimento;
    private String estado;
    private String cidade;
    private String cep;
    private String telefone;
    private String email;
    private String skype;
    private String status;
    private LocalDateTime datacadastro = LocalDateTime.now();

    public PessoaDTO(Pessoa objPessoa) {

        id = objPessoa.getId();
        nome = objPessoa.getNome();
        cpf = objPessoa.getCpf();
        datacadastro = objPessoa.getDatanascimento();
        estado = objPessoa.getEstado();
        cidade = objPessoa.getCidade();
        cep = objPessoa.getCep();
        telefone = objPessoa.getTelefone();
        email = objPessoa.getEmail();
        skype = objPessoa.getSkype();
        status = objPessoa.getStatus();
        datacadastro = objPessoa.getDatacadastro();

    }

}
