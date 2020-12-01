package com.opts.dto;

import java.time.LocalDateTime;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

public class PessoaDTO {

    String id;
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

}
