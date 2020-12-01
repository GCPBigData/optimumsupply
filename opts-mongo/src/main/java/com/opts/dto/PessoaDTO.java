package com.opts.dto;

import com.opts.documents.PessoaDoc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 01/12/2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pessoa")
public class PessoaDTO {

    @Id
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

    public PessoaDTO(PessoaDoc pessoaDoc) {
        id = pessoaDoc.getId();
        nome = pessoaDoc.getNome();
        cpf = pessoaDoc.getCpf();
        datanascimento = pessoaDoc.getDatanascimento();
        estado = pessoaDoc.getEstado();
        cidade = pessoaDoc.getCidade();
        cep = pessoaDoc.getCep();
        telefone = pessoaDoc.getTelefone();
        email = pessoaDoc.getEmail();
        skype = pessoaDoc.getSkype();
        status = pessoaDoc.getStatus();
        datacadastro = pessoaDoc.getDatacadastro();

    }
}
