package com.opts.documents;

import jdk.jfr.Name;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 30/10/2020
 */
@Data
@Document(collection = "TB_CLIENTES")
public class Clientes {
    @Id
    @Name("ID")
    String id;
    @Name("NOME")
    String nome;
    @Name("ENDERECO")
    String endereco;
    @Name("CIDADE")
    String cidade;
    @Name("ESTADO")
    String estado;
    @Name("PAIS")
    String pais;
    @Name("CONTATO")
    String contato;
    @Name("CPF_CNPJ")
    String cpfcnpj;

}
