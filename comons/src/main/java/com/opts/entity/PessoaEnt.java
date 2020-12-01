package com.opts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 30/11/2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa", schema = "test")
public class PessoaEnt {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pessoa")
    @SequenceGenerator(name = "sq_pessoa", sequenceName = "sq_pessoa", allocationSize = 1)
    private Long id;

    @Column("nome")
    public String nome;

    @Column("cpf")
    @Size(min = 11, max = 11)
    public String cpf;

    @Column("datanascimento")
    public LocalDateTime datanascimento;

    @Column("estado")
    public String estado;

    @Column("cidade")
    public String cidade;

    @Column("cep")
    public String cep;

    @Column("telefone")
    public String telefone;

    @Column("email")
    public String email;

    @Column("skype")
    public String skype;

    @Column("status")
    public String status;

    @Column("datacadastro")
    public LocalDateTime datacadastro = LocalDateTime.now();

}
