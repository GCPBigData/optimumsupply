package com.opts.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("pessoa")
public class Pessoa {

    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column("nome")
    @NonNull
    @Size(max = 100, message = "nome tamanho maximo 100 digitos")
    private String nome;

    @Column("cpf")
    @NonNull
    @Size(max = 11, message = "CPF tamanho naximo 11 digitos")
    private String cpf;

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