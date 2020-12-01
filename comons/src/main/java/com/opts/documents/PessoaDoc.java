package com.opts.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 30/11/2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pessoa")
public class PessoaDoc {
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

}