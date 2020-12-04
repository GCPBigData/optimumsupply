package com.opts.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 02/11/2020
 */

@Entity
@Table(name = "pessoa")
public class Pessoa {

    private long id;
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

    public Pessoa() {
    }

    public Pessoa(long id, String nome, String cpf, LocalDateTime datanascimento, String estado, String cidade, String cep, String telefone, String email, String skype, String status, LocalDateTime datacadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.skype = skype;
        this.status = status;
        this.datacadastro = datacadastro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDateTime getDatanascimento() {
        return datanascimento;
    }
    public void setDatanascimento(LocalDateTime datanascimento) {
        this.datanascimento = datanascimento;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSkype() {
        return skype;
    }
    public void setSkype(String skype) {
        this.skype = skype;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getDatacadastro() {
        return datacadastro;
    }
    public void setDatacadastro(LocalDateTime datacadastro) {
        this.datacadastro = datacadastro;
    }
}