package br.opts.dto;

import com.opts.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 02/11/2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

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

    public PessoaDTO(Pessoa objPessoa) {
        id = objPessoa.getId();
        nome = objPessoa.getNome();
        cpf = objPessoa.getCpf();
        datanascimento = objPessoa.getDatanascimento();
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