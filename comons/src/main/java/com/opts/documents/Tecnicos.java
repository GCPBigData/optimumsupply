package com.opts.documents;

import jdk.jfr.Name;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 30/10/2020
 */
@Data
@Getter
@Setter
@Document(collection = "TB_TECNICOS")
public class Tecnicos {
    @Id
    @Name("ID")
    String id;
    @Name("NOME")
    String nome;
    @Name("NOMERG")
    String rg;
    @Name("CPF")
    String cpf;
    @Name("DATA_NASCIMENTO")
    String datanascimento;
    @Name("MAE")
    String mae;
    @Name("ENDERECO")
    String endereco;
    @Name("CIDADE")
    String cidade;
    @Name("ESTADO")
    String estado;
    @Name("PAIS")
    String pais;
    @Name("TELEFONE")
    String telefone;
    @Name("BANCO")
    String banco;
    @Name("AGENCIA")
    String agencia;
    @Name("CONTA")
    String conta;
    @Name("TITULAR_CONTA")
    String titularconta;
    @Name("CPF_TITULAR_CONTA")
    String cpftitularconta;
    @Name("VALOR_CHAMADO")
    String valorchamado;
    @Name("VALOR_HORA")
    String valorhora;
    @Name("VALOR_MENSAL")
    String valormensal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getTitularconta() {
        return titularconta;
    }

    public void setTitularconta(String titularconta) {
        this.titularconta = titularconta;
    }

    public String getCpftitularconta() {
        return cpftitularconta;
    }

    public void setCpftitularconta(String cpftitularconta) {
        this.cpftitularconta = cpftitularconta;
    }

    public String getValorchamado() {
        return valorchamado;
    }

    public void setValorchamado(String valorchamado) {
        this.valorchamado = valorchamado;
    }

    public String getValorhora() {
        return valorhora;
    }

    public void setValorhora(String valorhora) {
        this.valorhora = valorhora;
    }

    public String getValormensal() {
        return valormensal;
    }

    public void setValormensal(String valormensal) {
        this.valormensal = valormensal;
    }
}
